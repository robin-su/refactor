package sjmszm.exception;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sjmszm.idrfc.IdGenerationFailureException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 当我们面对函数抛出异常的时候，应该选择上面的哪种处理方式呢？我总结了下面三个参考原则：
 * 1） 如果 func1() 抛出的异常是可以恢复，且 func2() 的调用方并不关心此异常，我们完全可以在 func2() 内将 func1() 抛出的异常吞掉；
 * 2） 如果 func1() 抛出的异常对 func2() 的调用方来说，也是可以理解的、关心的 ，并且在业务概念上有一定的相关性，我们可以选择直接将 func1 抛出的异常 re-throw；
 * 3） 如果 func1() 抛出的异常太底层，对 func2() 的调用方来说，缺乏背景去理解、且业务概念上无关，我们可以将它重新包装成调用方可以理解的新异常，然后 re-throw。
 */
public class RandomIdGenerator implements IdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);


    @Override
    public String generate() throws IdGenerationFailureException {
        String substrOfHostName = getLastFiledOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s",
                substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    private String getLastFiledOfHostName() {
        String substrOfHostName = null;
        try {
            /** generate函数如果本机名获取失败，函数返回什么？这样的返回值是否合理？**/
            String hostName = InetAddress.getLocalHost().getHostName();
            substrOfHostName = getLastSubstrSplittedByDot(hostName);
        } catch (UnknownHostException e) {
            /**
             * 对于 getLastFiledOfHostName() 函数，是否应该将 UnknownHostException
             * 异常在函数内部吞掉（try-catch 并打印日志）？还是应该将异常继续往上抛出？
             * 如果往上抛出的话，是直接把 UnknownHostException 异常原封不动地抛出，还是
             * 封装成新的异常抛出？
             */
            logger.warn("Failed to get the host name.", e);
        }
        return substrOfHostName;
    }

    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit= randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase= randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase= randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit|| isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
}

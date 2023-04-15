package sjmszm.idrfc;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class RandomIdGenerator implements LogTraceIdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

    @Override
    public String generate() throws IdGenerationFailureException {
        /**
         * 1. 调用者在使用 generate() 函数的时候，只需要知道它生成的是随机唯一 ID，并不关心 ID 是如何生成的。
         * 也就说是，这是依赖抽象而非实现编程。
         * 如果 generate() 函数直接抛出 UnknownHostException 异常，实际上是暴露了实现细节。
         *
         * 2.从代码封装的角度来讲，我们不希望将 UnknownHostException 这个比较底层的异常，暴露给更上层的代码，也就是调用 generate() 函数的代码。
         * 而且，调用者拿到这个异常的时候，并不能理解这个异常到底代表了什么，也不知道该如何处理。
         *
         * 3.UnknownHostException 异常跟 generate() 函数，在业务概念上没有相关性。
         */
        String subStrOfHostName = null;
        try {
            subStrOfHostName = getLastFiledOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("Host name is empty.");
        }
        if(subStrOfHostName == null || subStrOfHostName.isEmpty()) {
            throw new IdGenerationFailureException("host name is empty");
        }
        String randomChars = generateRandomAlphameric(8);
        String  id = String.format("%s-%d-%s",
                subStrOfHostName,
                System.currentTimeMillis(),
                new String(randomChars));
        return id;
    }

    private String getLastFiledOfHostName() throws UnknownHostException {
//        String subStrOfHostName = null;
//        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            if(hostName == null || hostName.isEmpty()) {
              throw new UnknownHostException("...");
            }
            String subStrOfHostName = getLastSubstrSplittedByDot( hostName);
//        }catch (UnknownHostException e) {
//            logger.warn("Failed to get the host name.", e);
            /**
             * getLastFieldOfHostName() 函数用来获取主机名的最后一个字段，UnknownHostException 异常表示主机名获取失败，两者算是业务相关，
             * 所以可以直接将 UnknownHostException 抛出，不需要重新包裹成新的异常。
             */

//        }
        return subStrOfHostName;
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        if(length <= 0) {
            throw new IllegalArgumentException("...");
        }

        char[] randomChars = new char[8];
        int count = 0;
        Random random = new Random();
        while(count < length)  {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9'; // 引入解释性变量
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if(isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                count ++;
            }
        }
        return new String(randomChars);
    }


    @VisibleForTesting
    protected static String getLastSubstrSplittedByDot(String hostName) {
        if(hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("...");
        }
        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }

    public static void main(String[] args) throws IdGenerationFailureException {
        LogTraceIdGenerator logTraceIdGenerator = new RandomIdGenerator();
        String generate = logTraceIdGenerator.generate();
        System.out.println(generate);
    }


}

package sjmszm.pattern.singleton.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 存在的问题：
 * 1.所有的日志都写入到同一个文件 /Users/wangzheng/log.txt 中。在UserController和OrderController中，
 * 我们分别创建两个Logger 对象。
 * 2.在Web容器的Servlet多线程环境下，如果两个Servlet线程同时分别执行login()和create()两个函数，并且同时
 * 写日志到log.txt文件中，那就有可能存在日志信息互相覆盖的情况。
 */
public class Logger {
    private FileWriter writer;

    private static final String LOG_PATH =
            "/Users/suyb/Documents/itWork/devworkspace/private/temp-demo/src/main/java/com/geeksu/cn/complete/refactor/sjmszm/pattern/singleton/log";

    public Logger() {
        File file = new File(LOG_PATH);
        try {
            writer = new FileWriter(file,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void log(String message)  {
        /**
         * 1.这种锁是一个对象级别的锁，一个对象在不同的线程下同时调用log() 函数，会被强制要求顺序执行。
         * 但是，不同的对象之间并不共享同一把锁。在不同的线程下，通过不同的对象调用执行log()函数，
         * 锁并不会起作用，仍然有可能存在写入日志互相覆盖的问题。
         * 2.因为FileWriter本身就是线程安全的，它的内部实现中本身就加了对象级别的锁，因此，在外层调用
         * write() 函数的时候，再加对象级别的锁实际上是多此一举。因为不同的Logger对象不共享FileWriter对象，
         * 所以，FileWriter 对象级别的锁也解决不了数据写入互相覆盖的问题。
         * 3.那我们该怎么解决这个问题呢？实际上，要想解决这个问题也不难，我们只需要把对象级别的锁，换成类级别的
         * 锁就可以了。让所有的对象都共享同一把锁。
         * 4.单例模式相对于之前类级别锁的好处是，不用创建那么多 Logger 对象，一方面节省内存空间，另一方面节省
         * 系统文件句柄（对于操作系统来说，文件句柄也是一种资源，不能随便浪费）。
         *
         */
//        synchronized(this) {// 对象级别的锁
//            try {
//                writer.write(message);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        synchronized (Logger.class) { // 类级别的锁，
            try {
                writer.write(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

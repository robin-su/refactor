package sjmszm.ratelimiter.rfc.alg;

import com.google.common.base.Stopwatch;
import sjmszm.ratelimiter.rfc.exception.InternalErrorException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedTimeWindowRateLimiter implements RateLimitAlg {

    private static final long TRY_LOCK_TIMEOUT = 200L;
    private Stopwatch stopWatch;
    private AtomicInteger currentCount = new AtomicInteger(0);
    private final int limit;
    private Lock lock = new ReentrantLock();

    public FixedTimeWindowRateLimiter(int limit) {
        this(limit, Stopwatch.createStarted());
    }

    protected FixedTimeWindowRateLimiter(int limit, Stopwatch stopWatch) {
        this.limit = limit;
        this.stopWatch = stopWatch;
    }

    @Override
    public boolean tryAcquire() throws InternalErrorException {
        int updatedCount = currentCount.incrementAndGet();
        if(updatedCount < limit) {
            return true;
        }
        try {
            if(lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MICROSECONDS)) {
                try {
                    //  超过1秒，则重新设置时间窗口
                    if(stopWatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
                        currentCount.set(0);
                        stopWatch.reset();
                    }
                    updatedCount = currentCount.incrementAndGet();
                    return updatedCount <= limit;
                } finally {
                    lock.unlock();
                }
            } else {
                throw new InternalErrorException("tryAcquire() wait lock too long:" + TRY_LOCK_TIMEOUT + "ms");
            }
        } catch (InterruptedException e) {
            throw new InternalErrorException("tryAcquire() is interrupted by lock-time-out.", e);
        }
    }


}

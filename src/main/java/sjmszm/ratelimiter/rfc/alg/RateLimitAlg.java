package sjmszm.ratelimiter.rfc.alg;

import sjmszm.ratelimiter.rfc.exception.InternalErrorException;

public interface RateLimitAlg {
    boolean tryAcquire() throws InternalErrorException;
}

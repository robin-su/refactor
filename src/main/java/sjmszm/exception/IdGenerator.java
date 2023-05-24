package sjmszm.exception;

import sjmszm.idrfc.IdGenerationFailureException;

public interface IdGenerator {
    String generate() throws IdGenerationFailureException;

}

package sjmszm.idrfc;

public interface IdGenerator {

    String generate() throws IdGenerationFailureException;

}

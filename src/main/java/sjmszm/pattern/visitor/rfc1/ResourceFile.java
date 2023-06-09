package sjmszm.pattern.visitor.rfc1;

public abstract class ResourceFile {

    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void accept(Extractor extractor);
    public abstract void accept(Compressor compressor);
}

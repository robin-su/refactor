package sjmszm.pattern.decorator;

public class BufferedInputStream extends InputStream {

    protected volatile InputStream in;

    public BufferedInputStream(InputStream in) {
        this.in = in;
    }

    //...实现基于缓存的读数据接口...
}

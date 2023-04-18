package sjmszm.pattern.decorator;

public class DataInputStream extends InputStream {

    protected volatile InputStream in;

    public DataInputStream(InputStream in) {
        this.in = in;
    }

    //...实现读取基本类型数据的接口
}

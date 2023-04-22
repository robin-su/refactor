package sjmszm.pattern.template.callback;

public class AClass {

    public static void main(String[] args) {
        BClass bClass = new BClass();
        bClass.process(new ICallback() {  // A类将methodToCallback函数注册给B类
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            }
        });
    }

}

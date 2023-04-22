package sjmszm.pattern.template.templatetocallback.rfc;

public class Client {

    public static void main(String[] args) {

        AbstractClass classIns = new AbstractClass(new MethodTemplate12() {
            @Override
            protected void method1() {
                System.out.println("method1");
            }

            @Override
            protected void method2() {
                System.out.println("method2");
            }
        });



        classIns.execute();

        System.out.println("++++++++++++++");

        AbstractClass classIns2 = new AbstractClass(new MethodTemplate34(){
            @Override
            protected void method3() {
                System.out.println("method3");
            }

            @Override
            protected void method4() {
                System.out.println("method4");
            }
        });

        classIns2.execute();
    }

}

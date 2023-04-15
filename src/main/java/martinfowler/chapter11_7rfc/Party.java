package martinfowler.chapter11_7rfc;

//1.建立一个超类，并将现有的两个类定义为其子类
abstract class Party {
    //2.1 把特性移动至超类
    private String name;

    // 3.1 把共同特性的取值函数也移动到超类
    public String getName() {
        return name;
    }

    //4.运行Pull Up Constructor body,保证name能被正确复制
    public Party(String name) {
        this.name = name;
    }

    //6.Department#getAnnualCost() 和Employee.getAnnualCost()两个函数的函数名相同，
    //函数体不同，所以在超类中声明一个抽象类
    abstract public int getAnnualCost();
}

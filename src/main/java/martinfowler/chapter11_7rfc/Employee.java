package martinfowler.chapter11_7rfc;

class Employee extends Party {
    //2.把特性移动至超类
//    private String name;
    private int annualCost;
    private String id;


    public Employee(String name, int annualCost, String id) {
        //4.1
        super(name);
        this.annualCost = annualCost;
        this.id = id;
    }
    // 3.把共同特性的取值函数也移动到超类
//    public String getName() {
//        return name;
//    }

    public int getAnnualCost() {
        return annualCost;
    }

    public String getId() {
        return id;
    }
}

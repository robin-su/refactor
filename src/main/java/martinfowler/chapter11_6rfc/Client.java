package martinfowler.chapter11_6rfc;

public class Client {

    public static void main(String[] args) {
        Employee kent = new Employee(50);
        // 3.找出对JobItem构造函数的调用，并从中找出可以改用LaborItem构造函数的地方
//        JobItem j1 = new JobItem(5, 0, true, kent);
        // JobItem j1 = new LaborItem(5, 0, true, kent);
        // 5.外部使用新的构造函数
        JobItem j1 = new LaborItem(5,kent);
//        JobItem j2 = new JobItem(15, 10, false, null);
//        JobItem j2 = new LaborItem(15, 10, false, null);
        JobItem j2 = new PartsItem(15, 10);
        int total = j1.getTotalPrice() + j2.getTotalPrice();
    }

}

package martinfowler.chapter9_17rfc;

class Client {

    /**
     * 这个系统中很多地方使用Site和Customer对象，他们都必须检查Customer对象是否等于null,
     * 而这样的检查完全是重复的
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 7.找出所有"将源对象与null做比较"的地方。修改这些地方，是他们调用isNull()函数
         */
        Site site = new Site();
        Customer customer = site.getCustomer();

//        if(customer == null) {
        //8.找出这样的程序点：如果对象不是null,做A动作，否则做B动作
        //8.1 在null子类中覆盖A动作，使其行为和B动作相同
        //9.使用上述被覆写的动作，然后删除"对象是否null"的条件测试。
        //9.1 因为NullCustomer中已经有对应实现方法类，所以这里可以去掉条件测试
//        if(customer.isNull()) {
//            plan = BillingPlan.basic();
//        } else {
//            customer.getPlan();
//        }
        BillingPlan plan = customer.getPlan();

        //9.2 因为NullCustomer中已经有对应实现方法类，所以这里可以去掉条件测试
        String customerName = customer.getName();
//        String customerName;
////        if(customer == null) {
//        if(customer.isNull()) {
//            customerName = "occupant";
//        } else {
//            customerName = customer.getName();
//        }


//        if(customer == null) {
        // 10.这个客户端调用使用了Customer函数的运算结果，要特殊处理
        // 10.1 同样的方式为PaymentHistory创建NullPaymentHistory
//        int weeksDelinquent;
//        if(customer.isNull()) {
//            weeksDelinquent = 0;
//        } else {
//            weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
//        }
        int weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();

    }

}

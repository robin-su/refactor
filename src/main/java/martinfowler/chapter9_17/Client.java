package martinfowler.chapter9_17;

class Client {

    /**
     * 这个系统中很多地方使用Site和Customer对象，他们都必须检查Customer对象是否等于null,
     * 而这样的检查完全是重复的
     *
     * @param args
     */
    public static void main(String[] args) {
        Site site = new Site();
        Customer customer = site.getCustomer();
        BillingPlan plan;
        if(customer == null) {
            plan = BillingPlan.basic();
        } else {
            customer.getPlan();
        }

        String customerName;
        if(customer == null) {
            customerName = "occupant";
        } else {
            customerName = customer.getName();
        }

        int weeksDelinquent;
        if(customer == null) {
            weeksDelinquent = 0;
        } else {
            weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
        }
    }

}

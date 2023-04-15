package martinfowler.chapter9_17rfc;

class BillingPlan {

    private int basicpay;
    private int extrapay;

    public BillingPlan() {
        setBasicpay(0);
        setExtrapay(0);
    }

    public BillingPlan(int pay) {
        this.basicpay = pay;
        setExtrapay(0);
    }

    public BillingPlan(int basic, int extra) {
        setBasicpay(basic);
        setExtrapay(extra);
    }

    static BillingPlan basic() {
        return new BillingPlan(100);//最低消费100
    }

    public int getTotalExpand() {
        return basicpay + extrapay;
    }

    public int getBasicpay() {
        return basicpay;
    }

    public void setBasicpay(int basicpay) {
        this.basicpay = basicpay;
    }

    public int getExtrapay() {
        return extrapay;
    }

    public void setExtrapay(int extrapay) {
        this.extrapay = extrapay;
    }
}

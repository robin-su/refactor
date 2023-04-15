package martinfowler.chapter11_6rfc;

public class PartsItem extends JobItem{

    private int unitPrice;

    public PartsItem(int quantity, int unitPrice) {
        super(quantity);
        this.unitPrice = unitPrice;
    }

    @Override
    int getUnitPrice() {
        return unitPrice;
    }
}

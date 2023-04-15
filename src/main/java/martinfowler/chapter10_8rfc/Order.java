package martinfowler.chapter10_8rfc;

public class Order {

    private int quantity;
    private int itemPrice;

    public Order(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice() {
        //5.去掉没用的变量
//        int basePrice = getBasePrice();
        //4.去掉discountLevel局部变量
        //7.去掉临时变量
//        double finalPrice = discountedPrice(basePrice);
        return discountedPrice();
    }

    // 5.临时变量使用访问函数替换
    private int getBasePrice() {
        return quantity * itemPrice;
    }

    // 1.将计算等级的代码提炼到一个类中
    private int getDiscountLevel() {
        int discountLevel;
        if(quantity >= 100) {
            discountLevel = 2;
        } else {
            discountLevel = 1;
        }
        return discountLevel;
    }

    //2.将discountedPrice函数中对discountLevel参数的所有引用点，替换为getDiscountLevel()
    //3.去掉discountLevel参数
    //6.变量使用访问函数进行替换
    private double discountedPrice() {
        if(getDiscountLevel() == 2) {
            return getBasePrice() * 0.1;
        } else {
            return getBasePrice() * 0.2;
        }
    }
}

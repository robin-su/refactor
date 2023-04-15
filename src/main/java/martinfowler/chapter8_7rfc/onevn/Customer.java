package martinfowler.chapter8_7rfc.onevn;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    //1. 为Customer提供一个字段，由于一个客户拥有多份订单，所以该字段是个集合属性【不重复】
    private Set<Order> orders = new HashSet<>();

    //2. 让Customer添加一个辅助函数，让Order可以直接访问订单集合,注意权限要尽量小，尽量不要暴露给外面
    Set<Order> friendOrders() {
        return this.orders;
    }

    //4.如果你希望Customer也能修改链接。则添加此函数
    void addOrder(Order arg) {
        arg.setCustomer(this);
    }


}

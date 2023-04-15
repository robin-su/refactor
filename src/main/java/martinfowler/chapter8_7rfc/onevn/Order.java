package martinfowler.chapter8_7rfc.onevn;

public class Order {
    // Order中持有Customer的单个引用，所以Order作为关联关系的控制端
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    //3. 改变"修改函数"，让他同时更新反向指针
    public void setCustomer(Customer arg) {
        //3.1 先让对方「Customer」删除指向你的指针
        if(this.customer != null) {
            this.customer.friendOrders().remove(this); // 保证一个订单只能对应一个Customer
        }
        //3.2 再将你的指针指向一个新对象arg
        customer = arg;
        //3.3 让那个新对象把他的指针只想你
        customer.friendOrders().add(this);
    }


}

package martinfowler.chapter9_17rfc;

class Site {

    private Customer _customer;

    //6.所有"返回null"的地方，都将它改为"返回空对象"
    public Customer getCustomer() {
//        return _customer;
        return (_customer == null) ? Customer.newNull() : _customer;
    }

    public void setCustomer(Customer customer) {
        this._customer = customer;
    }
}

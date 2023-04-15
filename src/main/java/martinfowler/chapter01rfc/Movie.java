package martinfowler.chapter01rfc;

public class Movie {
    //三种片类型
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    //三种片类型
    private Price price;

    private String title;
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    protected double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    protected int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return title;
    }



}

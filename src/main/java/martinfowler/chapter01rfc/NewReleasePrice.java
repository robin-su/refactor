package martinfowler.chapter01rfc;

public class NewReleasePrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented) {
        //果然还是新书最贵啊
        return daysRented * 3;
    }

    @Override
    protected int getFrequentRenterPoints(int daysRented) {
        return daysRented >= 1 ? 2 : 1;
    }
}

package martinfowler.chapter11_10rfc;

import com.geeksu.cn.complete.refactor.martinfowler.chapter01rfc.Movie;

public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    double getCharge(int daysRented) {
        double result = 2;
        //优惠力度
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}

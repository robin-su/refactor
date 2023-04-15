package martinfowler.chapter11_10;


public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    protected double getCharge() {
       return movie.getCharge(daysRented);
    }

    protected int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}

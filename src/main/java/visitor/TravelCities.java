package visitor;

public class TravelCities implements City{

    City[] cities;

    public TravelCities() {
        cities = new City[] {new Beijing(),new Shanghai(),new Shenzhen()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (City city : cities) {
            city.accept(visitor);
        }
    }
}

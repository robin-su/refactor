package refactoringtopatterns.build.CompositeMultiBranch;

public class BelowPriceSpec extends Spec {

    private float price;

    public BelowPriceSpec(float price) {
        this.price = price;
    }


    @Override
    boolean isSatisfiedBy(Product product) {
        return Float.compare(price, product.getPrice()) > 0;
    }

    public static void main(String[] args) {
        Product frisbee = new Product("b4321",
                "Frisbee",
                Color.pink,
                9.99f,
                ProductSize.LARGE);

        BelowPriceSpec belowPriceSpec = new BelowPriceSpec(10.0f);
        boolean satisfiedBy = belowPriceSpec.isSatisfiedBy(frisbee);
        System.out.println(satisfiedBy);
    }
}

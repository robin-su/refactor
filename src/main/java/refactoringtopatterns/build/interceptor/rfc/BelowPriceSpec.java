package refactoringtopatterns.build.interceptor.rfc;

public class BelowPriceSpec extends Spec {

    private float priceThreshold;

    public BelowPriceSpec(float priceThreshold) {
        this.priceThreshold = priceThreshold;
    }

    @Override
    boolean isSatisfiedBy(Product product) {
        return product.getPrice() < getPriceThreshold();
    }

    public float getPriceThreshold() {
        return priceThreshold;
    }
}

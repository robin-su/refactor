package refactoringtopatterns.build.CompositeMultiBranch.rfc;

public class SizeSpec extends Spec {

    private ProductSize productSize;

    public SizeSpec(ProductSize productSize) {
        this.productSize = productSize;
    }

    @Override
    boolean isSatisfiedBy(Product product) {
        return productSize.equals(product.getProductSize());
    }
}

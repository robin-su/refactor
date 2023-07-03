package refactoringtopatterns.build.CompositeMultiBranch;

public class ColorSpec extends Spec {

    private Color color;

    public ColorSpec(Color color) {
        this.color = color;
    }

    @Override
    boolean isSatisfiedBy(Product product) {
        return color.equals(product.getColor());
    }
}

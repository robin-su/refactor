package refactoringtopatterns.build.interceptor.rfc;

/**
 * 7.2 组合规格类
 */
public class NotSpec extends Spec {

    private Spec specToNegate;

    public NotSpec(Spec specToNegate) {
        this.specToNegate = specToNegate;
    }


    @Override
    boolean isSatisfiedBy(Product product) {
        return !specToNegate.isSatisfiedBy(product);
    }
}

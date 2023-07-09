package refactoringtopatterns.build.interceptor.rfc;

/**
 * 6.1
 */
// 6.4
public class AndSpec extends Spec {

    private Spec augend, adend;

    public AndSpec(Spec augend, Spec adend) {
        this.augend = augend;
        this.adend = adend;
    }

    public Spec getAugend() {
        return augend;
    }

    public Spec getAdend() {
        return adend;
    }

    @Override
    boolean isSatisfiedBy(Product product) {
        return getAugend().isSatisfiedBy(product)
                && getAdend().isSatisfiedBy(product);
    }
}

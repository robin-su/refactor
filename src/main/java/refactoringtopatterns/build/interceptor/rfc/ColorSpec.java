package refactoringtopatterns.build.interceptor.rfc;

/**
 * 1.2 为选择逻辑条件参数创建规则类
 */
public class ColorSpec extends Spec {

    private Color colorOfProductToFind;

    public ColorSpec(Color colorOfProductToFind) {
        this.colorOfProductToFind = colorOfProductToFind;
    }

    //3.3 将isSatisfiedBy 搬移到 ColorSpec
    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getColor().equals(getColorOfProductToFind());
    }

    public Color getColorOfProductToFind() {
        return colorOfProductToFind;
    }
}

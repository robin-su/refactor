package refactoringtopatterns.build.interceptor.rfc;

/**
 * 4.创建规格类的超类，并将isSatisfiedBy方法提炼到这个超类
 */
public abstract class Spec {

    abstract boolean isSatisfiedBy(Product product);

}

package refactoringtopatterns.build.CompositeMultiBranch.rfc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 1.创建一个类用于接收public List<Product> selectBy(List<Spec> specs)的参数List<Spec> specs
 * 5. 将CompositeSpec申明为Spec的子类
 */
public class CompositeSpec extends Spec {

    private List<Spec> specs = new ArrayList<>();

    //7.4
//    public CompositeSpec(List<Spec> specs) {
//        this.specs = specs;
//    }

    // 3.1 提炼方法
    // 3.2 搬移方法
    boolean isSatisfiedBy(Product product) {
        Iterator<Spec> specifications = getSpecs().iterator();
        boolean satisfiesAllSpecs = true;
        while (specifications.hasNext()) {
            Spec productSpec = specifications.next();
            satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
        }
        return satisfiesAllSpecs;
    }

    //7.封装集合
    public List<Spec> getSpecs() {
        return Collections.unmodifiableList(specs);
    }

    //7.1 封装集合
    public void add(Spec spec){
        specs.add(spec);
    }




}

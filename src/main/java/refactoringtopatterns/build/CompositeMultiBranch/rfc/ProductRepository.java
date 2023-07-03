package refactoringtopatterns.build.CompositeMultiBranch.rfc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public Iterator<Product> iterator() {
        return products.iterator();
    }

    protected List<Product> selectBy(Spec spec) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if(spec.isSatisfiedBy(product)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    /**
     * 2.把基于List参数的selectBy方法搬移到这个新类
     * @param specs
     * @return
     */
//    public List<Product> selectBy(List<Spec> specs) {
        //2.1
//        CompositeSpec spec = new CompositeSpec(specs);
//        ArrayList<Product> foundProducts = new ArrayList<>();
//        Iterator<Product> products = iterator();
//        while (products.hasNext()) {
//            Product product = products.next();
            //2.2
//            Iterator<Spec> specifications = specs.iterator();
            //3. 在专门处理specs的代码上提炼方法
//            Iterator<Spec> specifications = spec.getSpecs().iterator();
//
//            boolean satisfiesAllSpecs = true;
//            while (specifications.hasNext()) {
//                Spec productSpec = specifications.next();
//                satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
//            }

//            boolean satisfiesAllSpecs = isSatisfiedBy(spec, product);
//            if(spec.isSatisfiedBy(spec, product)) {
//                foundProducts.add(product);
//            }
//        }
//        return foundProducts;

        //4. 基于使用List的selectBy去调用单一spec的selectBy方法,因为重构两个方法一摸一样，只是List的多了一个CompositeSpec实例化
//        return selectBy(new CompositeSpec(specs));
//    }

    // 3.1 提炼方法
    // 3.2 搬移方法
//    private static boolean isSatisfiedBy(CompositeSpec spec, Product product) {
//        Iterator<Spec> specifications = spec.getSpecs().iterator();
//        boolean satisfiesAllSpecs = true;
//        while (specifications.hasNext()) {
//            Spec productSpec = specifications.next();
//            satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
//        }
//        return satisfiesAllSpecs;
//    }

    public void add(Product product) {
        products.add(product);
    }


}

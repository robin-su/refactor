package refactoringtopatterns.build.CompositeMultiBranch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public List<Product> selectBy(Spec spec) {
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

    public List<Product> selectBy(List<Spec> specs) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = iterator();
        while (products.hasNext()) {
            Product product = products.next();
            Iterator<Spec> specifications = specs.iterator();
            boolean satisfiesAllSpecs = true;
            while (specifications.hasNext()) {
                Spec productSpec = specifications.next();
                satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
            }
            if(satisfiesAllSpecs) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public void add(Product product) {
        products.add(product);
    }


}

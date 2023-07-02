package refactoringtopatterns.build.CompositeMultiBranch;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ProductReposityTest extends TestCase {

    private ProductRepository repository;

    private Product fireTruck = new Product("f1234",
            "Fire Truck",
            Color.red,
            8.95f,
            ProductSize.MEDIUM);

    private Product barbieClassic = new Product("b7654",
            "Babie Classic",
            Color.yellow,
            15.95f,
            ProductSize.SMALL);


    private Product frisbee = new Product("b4321",
            "Frisbee",
            Color.pink,
            9.99f,
            ProductSize.LARGE);

    private Product baseball = new Product("b2343",
            "Baseball",Color.white,
            8.95f,
            ProductSize.NOT_APPLICABLE);

    private Product toyConvertible = new Product("p1112",
            "Toy Porsche",
            Color.red,
            230.00f,
            ProductSize.NOT_APPLICABLE);

    protected void setUp() {
        repository = new ProductRepository();
        repository.add(fireTruck);
        repository.add(barbieClassic);
        repository.add(frisbee);
        repository.add(baseball);
        repository.add(toyConvertible);
    }

    public void testFindByColor() {
        List<Product> foundProducts = repository.selectBy(new ColorSpec(Color.red));
        assertEquals("found 2 red products",2,foundProducts.size());
        assertTrue("found fireTruck",foundProducts.contains(fireTruck));
        assertTrue("found Toy Porsche Convertible", foundProducts.contains(toyConvertible));
    }

    public void testFindByColorSizeAndBelowPrice() {
        List<Spec> specs = new ArrayList<>();
        specs.add(new ColorSpec(Color.red));
        specs.add(new SizeSpec(ProductSize.SMALL));
        specs.add(new BelowPriceSpec(10.00f));

        List<Product> foundProducts = repository.selectBy(specs);
        assertEquals("small red products below $10.00",0,foundProducts.size());
    }

}

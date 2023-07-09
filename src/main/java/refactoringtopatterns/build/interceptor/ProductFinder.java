package refactoringtopatterns.build.interceptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductFinder {

    private ProductRepository repository;

    public ProductFinder(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * 1. 选出逻辑条件依赖于条件参数的对象选择方法
     * 1.1 为条件参数 Color colorOfProductToFind 创建一个具体规则类，规格类必须包含Color，本例为ColorSpec
     * @param colorOfProductToFind
     * @returnColor colorOfProductToFind
     */
    public List<Product> byColor(Color colorOfProductToFind) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if(product.getColor().equals(colorOfProductToFind)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> byPrice(float priceLimit) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if(product.getPrice() == priceLimit) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> byColorSizeAndBlowPrice(Color color, int size, float price) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if (product.getColor() == color
                && product.getSize() == size
                && product.getPrice() < price) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> belowPriceAvoidingAColor(float price, Color color) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if(product.getPrice() < price && product.getColor() != color) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

}

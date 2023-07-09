package refactoringtopatterns.build.interceptor.rfc;

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
        /**
         * 2. 用规则类的访问方法的饮用来替换对参数colorOfProductToFind的引用
         */
        ColorSpec spec = new ColorSpec(colorOfProductToFind);

        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        //3. 使用提取方法重构，把while循环中的条件语句提取成isSatisfiedBy
        while (products.hasNext()) {
            Product product = products.next();
            //3.1
//            if(product.getColor().equals(spec)) {
            // 3.2
            if(spec.isSatisfiedBy(product)) {
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

    public List<Product> belowPrice(float price) {
        BelowPriceSpec spec = new BelowPriceSpec(price);
        return selectBy(spec);
    }

    private List<Product> selectBy(BelowPriceSpec spec) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if(spec.isSatisfiedBy(product)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }


    /**
     * 5. 继续使用上述方法提炼超类
     *
     * @param color
     * @param price
     * @return
     */
    public List<Product> byColorSizeAndBlowPrice(Color color, float price) {
        //5.1
        ColorSpec colorSpec = new ColorSpec(color);
        // 5.2
        BelowPriceSpec priceSpec = new BelowPriceSpec(price);

        //6.3
        AndSpec spec = new AndSpec(colorSpec, priceSpec);

        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            // 5.3
            /*if (product.getColor() == color
                && product.getSize() == size
                && product.getPrice() < price) {
                foundProducts.add(product);
            }*/
            // 6. 继续改进用组合规则类
            // 6.5
            if(spec.isSatisfiedBy(product)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    /**
     * 7. 继续抽取组合规格类
     *
     * @param color
     * @param price
     * @return
     */
    public List<Product> belowPriceAvoidingAColor(Color color,float price) {

        AndSpec spec = new AndSpec(
                new BelowPriceSpec(price),
                new NotSpec(new ColorSpec(color))
        );

        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            // 7.2
//            if(product.getPrice() < price && product.getColor() != color) {
//                foundProducts.add(product);
//            }
            if(spec.isSatisfiedBy(product)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    /**
     * 对所有的选择方法提炼方法
     */


}

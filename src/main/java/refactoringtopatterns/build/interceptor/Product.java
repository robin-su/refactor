package refactoringtopatterns.build.interceptor;

public class Product {

    private String code;
    private String name;
    private Color color;
    private float price;
    private ProductSize productSize;

    public Product(String code, String name, Color color, float price, ProductSize productSize) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.price = price;
        this.productSize = productSize;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public int getSize() {
        return productSize.getSize();
    }


}

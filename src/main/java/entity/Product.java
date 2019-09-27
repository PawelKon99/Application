package entity;

public class Product {

    private String color;
    private String productName;
    private Long id;
    private float price;
    private float weight;
    private Integer productCount;

    public Product(Long id, String productName, Float price, Float weight, String color, Integer productCount){
        this.color = color;
        this.productCount = productCount;
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return id + PRODUCT_SEPARATOR + productName + PRODUCT_SEPARATOR + price + PRODUCT_SEPARATOR + weight + PRODUCT_SEPARATOR + color + PRODUCT_SEPARATOR + productCount;
    }

    public String getColour() {
        return color;
    }

    public String getProductName() {
        return productName;
    }

    public Long getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public float getWeight() {
        return weight;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public final static String PRODUCT_SEPARATOR = "#";


}

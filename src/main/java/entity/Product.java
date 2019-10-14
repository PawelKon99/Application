package entity;

import entity.enums.Color;
import entity.enums.ProductSeparators;

public class Product {



    private Color color;
    private String productName;
    private Long id;
    private float price;
    private float weight;
    private Integer productCount;

    public Product(Long id, String productName, Float price, Float weight, Color color, Integer productCount){
        this.color = color;
        this.productCount = productCount;
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.productCount = productCount;
    }

    public Product(Long id, String productName, Float price, Float weight, Integer productCount) {

    }

    protected String getBasicProductString() {
        return id + ProductSeparators.PRODUCT_SEPARATOR.toString() + productName + ProductSeparators.PRODUCT_SEPARATOR.toString() + price + ProductSeparators.PRODUCT_SEPARATOR.toString() + weight + ProductSeparators.PRODUCT_SEPARATOR.toString() + color + ProductSeparators.PRODUCT_SEPARATOR.toString() + productCount;
    }

    @Override
    public String toString() {
        return ProductSeparators.PRODUCT_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString();
    }


    public Color getColor() {
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




}

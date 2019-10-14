package entity;

import entity.enums.Color;
import entity.enums.Material;
import entity.enums.ProductSeparators;

public class Clothes extends Product {



    private String size;
    private Material material;

    public Clothes(Long id, String productName, Float price, Float weight, Color color, Integer productCount, String size, Material material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    @Override
    public String toString() {
        return ProductSeparators.CLOTH_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + material;
    }

    public String getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }
}

package entity;

public class Clothes extends Product {

    private String size;
    private String material;

    public Clothes(Long id, String productName, Float price, Float weight, String color, Integer productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String toString(){
        return super.toString() + "Ubranie{" + "rozmiar: " + size + "materiał: " + material + "}";
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }
}

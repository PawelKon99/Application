package entity;

public class Clothes extends Product {

    private String size;
    private String material;

    public Clothes(String colour, String productName, int id, int price, int weight, int productCount, String size, String material) {
        super(colour, productName, id, price, weight, productCount);
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

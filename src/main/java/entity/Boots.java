package entity;

public class Boots extends Product {

    private Integer size;
    private  boolean isNaturalSkin;

    public Boots(Long id, String productName, Float price, Float weight, String color, Integer productCount, Integer size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public String toString(){

        return super.toString() + "Buty{" + "rozmiar: " + size + "czy ze skóry?: " + isNaturalSkin + "}";
    }

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }
}

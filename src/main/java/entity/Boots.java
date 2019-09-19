package entity;

public class Boots extends Product {

    private int size;
    private  boolean isNaturalSkin;

    public Boots(String colour, String productName, int id, int price, int weight, int productCount, int size, boolean isNaturalSkin) {
        super(colour, productName, id, price, weight, productCount);
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

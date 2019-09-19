package entity;

public class Product {

    private  String colour;
    private String productName;
    private int id;
    private  int price;
    private  int weight;
    private  int productCount;

    public Product(String colour, String productName, int id, int price, int weight, int productCount){
        this.colour = colour;
        this.productCount = productCount;
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.productCount = productCount;
    }

    public String toString(){
        return "Product{" + "kolor: " + colour + "Nazwa produktu: " + productName + "id produktu: " + id + "cena: " + price + "waga: " + weight+"ilosc produktów: " + productCount + "}" ;
    }

    public String getColour() {
        return colour;
    }

    public String getProductName() {
        return productName;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}

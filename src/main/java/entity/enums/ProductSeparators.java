package entity.enums;

public enum ProductSeparators {
    PRODUCT_SEPARATOR("#"),PRODUCT_ID("P"),CLOTH_ID("C"),BOOTS_ID("B");

    private String word;

    ProductSeparators(String separators){
        this.word = separators;
    }

    public String getWord(){
        return word;
    }

    public String toString(){
        return word;
    }

    public static ProductSeparators getIdByChar(String separators){
        for (ProductSeparators id : ProductSeparators.values()){
            if (id.getWord().equals(separators)){
                return id;
            }
        }
        return null;
    }


}

package entity.parser;

import entity.Boots;
import entity.Clothes;
import entity.Product;
import entity.enums.Color;
import entity.enums.Material;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

public class ProductParser {

    public static ProductSeparators getIdByChar(String word){
        for (ProductSeparators id : ProductSeparators.values()){
            if (id.getWord().equals(word)){
                return id;
            }
        }
        return null;
    }

    public static Product stringToProduct(String productStr) {
        final ProductSeparators productType = ProductSeparators.getIdByChar(productStr.substring(0, 1));
        switch (productType) {
            case PRODUCT_ID:
                return convertToProduct(productStr);
            case CLOTH_ID:
                return convertToCloth(productStr);
            case BOOTS_ID:
                return convertToBoots(productStr);
        }
        return null;
    }

    private static Boots convertToBoots(String productStr) {
        String [] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStringToCOLOR(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);
        Integer size = Integer.parseInt(productInformations[7]);
        SkinType skinType = SkinParser.parseStringToSkinType(productInformations[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, skinType);
    }

    private static Clothes convertToCloth(String productStr) {
        String [] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStringToCOLOR(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        Material material = MaterialParser.parseStringToMATERIAL(productInformations[8]);

        return new Clothes(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String productStr) {
        String [] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStringToCOLOR(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }


}
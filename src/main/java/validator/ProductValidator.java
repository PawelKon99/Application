package validator;

import api.ProductService;
import api.UserService;
import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import service.ProductServiceImpl;

import java.io.IOException;

public class ProductValidator {

    private ProductValidator(){}

    private static ProductValidator instance = null;


    public static ProductValidator getInstance(){
        if (instance==null){
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product)throws ProductWeightNoPositiveException, ProductCountNegativeException, ProductNameEmptyException, ProductPriceNoPositiveException{
        if (priceIsLowerThan0(product.getPrice())){
            throw new ProductPriceNoPositiveException("Cena jest niższa niż 0");
        }
        if (countOfProductsLowerThan0(product.getProductCount())){
            throw new ProductCountNegativeException("Liczba produktow jest mniejsza niz 0");
        }
        if (weightIsLowerThan0(product.getWeight())){
            throw new ProductWeightNoPositiveException("Waga jest mniejsza niż 0");
        }
        if (productNameIsEmpty(product.getProductName())){
            throw new ProductNameEmptyException("Produkt nie istnieje");
        }

        return true;
    }

    public boolean priceIsLowerThan0(float price){
        return price <= 0;
    }

    public boolean countOfProductsLowerThan0(Integer productCount){
        return productCount < 0;
    }

    public  boolean weightIsLowerThan0 (float weight){
        return weight <= 0;
    }

    public boolean productNameIsEmpty(String productName){
        return productName.length() == 0;

    }


}

import api.ProductService;
import api.UserRegisterLoginFacade;
import api.UserService;
import entity.Boots;
import entity.Clothes;
import entity.Product;
import entity.User;
import entity.enums.Color;
import entity.enums.Material;
import entity.enums.SkinType;
import entity.parser.ColorParser;
import entity.parser.MaterialParser;
import entity.parser.SkinParser;
import facade.UserRegisterLoginFacadeImpl;
import service.ProductServiceImpl;
import service.UserServiceImpl;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    static Scanner scanner =new Scanner(System.in);

    public static Product createOtherProduct(){
        String productName;
        Color color;
        Float price, weight;
        Integer count;
        System.out.println("ProductName: ");
        productName=scanner.next();
        System.out.println("Color: ");
        color=ColorParser.parseStringToCOLOR(scanner.next());
        System.out.println("Price: ");
        price = scanner.nextFloat();
        System.out.println("Weight: ");
        weight = scanner.nextFloat();
        System.out.println("Count: ");
        count = scanner.nextInt();

        return new Product(1l,productName,price,weight,color,count);
    }

    public static Product createBootsProduct() {
        String productName;
        Color color;
        Float price, weight;
        Integer count, size;
        SkinType skinType;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: ");
        color = ColorParser.parseStringToCOLOR(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.nextInt();

        System.out.println("Is natural skin: ");
        skinType = SkinParser.parseStringToSkinType(scanner.next());


        return new Boots(1L, productName, price, weight, color,count, size, skinType);
    }

    public static Product createClothProduct(){
        String productName, size;
        Color color;
        Material material;
        Float price, weight;
        Integer count;
        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: ");
        color = ColorParser.parseStringToCOLOR(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.next();

        System.out.println("Material: ");
        material = MaterialParser.parseStringToMATERIAL(scanner.next());

        return new Clothes(1l,productName,price,weight,color,count,size,material);
    }

    public static void startMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Zarejestruj się");
        System.out.println("0 - Wyjdź");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy product");
        System.out.println("0 - Wyloguj się");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
    }

    public static void main(String[] args) {
        int data = -1;


        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();

        boolean appOn=true;
        boolean loogedOn=false;
        int read;

        while (appOn){
            startMenu();
            read = scanner.nextInt();

            switch (read){
                case 1:
                    System.out.println("Podaj login");
                    String logginUsr = scanner.nextLine();
                    System.out.println("Podaj Hasło");
                    String passwordUsr = scanner.nextLine();
                    if (userFacade.loginUser(logginUsr,passwordUsr)){
                        loogedOn=true;
                        System.out.println("Zalogowałes sie");
                    }else{
                        System.out.println("Niepoprawne logowanie");
                    }
                    break;
                case 2:
                    System.out.println("Wybierz swój login");
                    String logginChoose = scanner.nextLine();
                    System.out.println("Wybierz swoje hasło");
                    String passwordChoose = scanner.nextLine();
                    User user = new User(1l,logginChoose,passwordChoose);
                    if (userFacade.registerUser(user)){
                        System.out.println("Zarejestrowałes sie");
                    }else{
                        System.out.println("Cos poszło nie tak");
                    }
                    break;
                case 0:
                    appOn=false;
                    break;
            }

            while (loogedOn){
                loggedMenu();
                read = scanner.nextInt();

                switch(read){
                    case 1:
                        productTypeMenu();
                        read = scanner.nextInt();
                        Product product = null;
                        switch (read){
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;
                            case 3:
                                product = createOtherProduct();
                                break;
                        }
                        if (productService.saveProduct(product)){
                            System.out.println("Produkt został utworzony");
                        }else {
                            System.out.println("Produkt nie został utworzony");
                        }
                    case 0:
                        loogedOn = false;
                        break;
                }
            }
        }
    }
}


package entity.parser;

import entity.enums.Color;

public class ColorParser {

    public static Color parseStringToCOLOR(String str){
        String color = str.toUpperCase();

        if (str.equals("RED")){
            return Color.RED;
        }
        else if (str.equals("BLUE")){
            return Color.BLUE;
        }
        else if (str.equals("BLACK")){
            return Color.BLACK;
        }
        else if (str.equals("GREEN")){
            return Color.GREEN;
        }
        else if (str.equals("YELLOW")){
            return Color.YELLOW;
        }
        else if (str.equals("WHITE")){
            return Color.WHITE;
        }

        return Color.WHITE;
    }
}

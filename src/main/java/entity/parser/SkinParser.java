package entity.parser;

import entity.enums.SkinType;

public class SkinParser {

    public static SkinType parseStringToSkinType(String str){
        String skin = str.toUpperCase();

        if (str.equals("NATURAL")){
            return SkinType.NATURAL;
        }
        else if (str.equals("ARTIFICAL")){
            return SkinType.ARTIFICAL;
        }
        return SkinType.ARTIFICAL;
    }
}

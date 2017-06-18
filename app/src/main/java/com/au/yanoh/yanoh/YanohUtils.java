package com.au.yanoh.yanoh;

/**
 * Created by ahmetu on 18.06.2017.
 */

public class YanohUtils {
    public static float HarfKatsayisiAl(String harf){
        switch (harf)
        {
            case "AA":
                return 4f;
            case "BA":
                return 3.5f;
            case "BB":
                return 3f;
            case "CB":
                return 2.5f;
            case "CC":
                return 2f;
            case "DC":
                return 1.5f;
            case "DD":
                return 1f;
            case "FD":
                return 0.5f;
            case "FF":
                return 0;
            default:
                return -1;
        }

    }

}


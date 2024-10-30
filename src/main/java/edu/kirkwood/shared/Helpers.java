package edu.kirkwood.shared;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Helpers {
    public static String round(double number, int numDecPlaces) {
        // Source: https://chatgpt.com/share/671fcc74-41d4-8007-9179-f0f8586b5908
        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        bigDecimal = bigDecimal.setScale(numDecPlaces, RoundingMode.HALF_UP);
        bigDecimal = bigDecimal.stripTrailingZeros();
        return bigDecimal.toString();
    }
}


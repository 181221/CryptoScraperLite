package no.pederyo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CoinUtil {
    public static String formaterTall(double verdi) {
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(verdi);
    }
    public static double gjorOmDoubleTilBC(double forje, String operator, double differanse) {
        BigDecimal b = new BigDecimal(forje);
        BigDecimal b1 = new BigDecimal(differanse);
        BigDecimal b2;
        switch (operator) {
            case "pluss":
                b2 = b.add(b1);
                break;
            case "minus":
                b2 = b.subtract(b1);
                break;
            case "gange":
                b2 = b.multiply(b1);
                break;
            default:
                return -1;
        }
        return formaterDouble(b2.doubleValue(), "##.0000");
    }


    public static double formaterDouble(double verdi, String pattern) {
        DecimalFormat f = new DecimalFormat(pattern);
        String verdien = f.format(verdi).toString().replace(',', '.');
        return Double.parseDouble(verdien);
    }
}

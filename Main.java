package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {

        int cont = 0;
	    BigDecimal valores[] = new BigDecimal[3];
	    BigDecimal a, b, c;
	    valores[0] = new BigDecimal("0");
        valores[1] = new BigDecimal("0");
        valores[2] = new BigDecimal("0");

        do{
            a = valores[0];
            b = valores[1];
            c = valores[2];

            System.out.println(cont);
            cont++;
            System.out.println(a + " " + b + " " + c);

            valores[0] = x1(b, c);
            valores[1] = x2(a, c);
            valores[2] = x3(a, b);
        }while (!(a.subtract(valores[0]).abs().compareTo(new BigDecimal("0.001")) == -1 && a.subtract(valores[0]).abs().compareTo(new BigDecimal("0.001")) == -1  && a.subtract(valores[0]).abs().compareTo(new BigDecimal("0.001")) == -1));

    }

    public static BigDecimal x1(BigDecimal y, BigDecimal z) {
        // (19 - y - z) 3;
        BigDecimal r = new BigDecimal("19");
        r = r.subtract(y);
        r = r.subtract(z);
        r = r.divide(new BigDecimal("3"),3, RoundingMode.CEILING);
        return r;
    }

    public static BigDecimal x2(BigDecimal x, BigDecimal z) {
        // (18 - 2x + z) / 3;
        BigDecimal r = new BigDecimal("18");
        r = r.subtract((new BigDecimal("2").multiply(x)));
        r = r.add(z);
        r = r.divide(new BigDecimal("3"),3, RoundingMode.CEILING);
        return r;
    }

    public static BigDecimal x3(BigDecimal x, BigDecimal y){
        // (6 - x + y) / 4

        BigDecimal r = new BigDecimal("6");
        r = r.subtract(x);
        r = r.add(y);
        r = r.divide(new BigDecimal("4"),3, RoundingMode.CEILING);
        return r;
    }

}

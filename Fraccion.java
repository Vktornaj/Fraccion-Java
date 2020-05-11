package com.company;

import java.util.Stack;

public class Fraccion {
    long num;
    long den;
    static int numerosPrimos[] = generarPrimos(500000000);

    public Fraccion(long num, long den) {
        this.num = num;
        this.den = den;
    }

    public Fraccion norm(){
        if (this.den < 0) {
            return new Fraccion(this.num * -1, this.den * -1);
        }
        return this;
    }

    public Fraccion sumar(Fraccion b) {
        Fraccion a = this.norm();
        b = b.norm();
        long mcm = mcm(this.den, b.den);
        Fraccion r = new Fraccion(mcm / this.den * this.num + mcm / b.den * b.num, mcm);
        return r.norm();
    }

    public Fraccion multi(Fraccion b) {
        return new Fraccion(this.num * b.num, this.den * b.den).norm();
    }

    public Fraccion restar(Fraccion b) {
        long mcm = this.den * b.den;
        return new Fraccion(mcm / this.den * this.num - mcm / b.den * b.num, mcm).norm();
    }

    public Fraccion dividir(Fraccion b) {
        return new Fraccion(this.num * b.den, this.den * b.num).norm();
    }

    public Fraccion mini() {
        System.out.println("mini...");
        long num = this.num;
        long den = this.den;
        long mcd = mcd(num, den);
        //if (num >= 0) {
            return new Fraccion(num / mcd, den / mcd).norm();
//        }else {
//            for (long i = num; i < 0 ; i++) {
//                if (num % i == 0) {
//                    if (den % i == 0) {
//                        num = num / i;
//                        den = den / i;
//                        return new Fraccion(num, den).norm();
//                    }
//                }
//            }
//        }
//        return new Fraccion(num, den).norm();
    }

    public int mcm(long a, long b) {
        Stack<Integer> nums = new Stack<Integer>();
        int cont = 0;
        do{
            if (a % numerosPrimos[cont] == 0 || b % numerosPrimos[cont] == 0) {
                nums.push(numerosPrimos[cont]);
                if (a % numerosPrimos[cont] == 0){
                    a = a / numerosPrimos[cont];
                }
                if (b % numerosPrimos[cont] == 0){
                    b = b / numerosPrimos[cont];
                }
            }else{
                cont++;
            }
        }while(!(a == 1 && b == 1));
        cont = 1;
        while (!nums.isEmpty()){
            cont = cont * nums.pop();
        }
        return cont;
    }

    public static int mcd(long a, long b){
        Stack<Integer> nums = new Stack<Integer>();
        a = Math.abs(a);
        b = Math.abs(b);
        int cont = 0;
        do{
            if (a % numerosPrimos[cont] == 0 && b % numerosPrimos[cont] == 0) {
                nums.push(numerosPrimos[cont]);
                if (a % numerosPrimos[cont] == 0){
                    a = a / numerosPrimos[cont];
                }
                if (b % numerosPrimos[cont] == 0){
                    b = b / numerosPrimos[cont];
                }
            }else{
                cont++;
            }
        }while(a >= numerosPrimos[cont] && b >= numerosPrimos[cont]);
        cont = 1;
        while (!nums.isEmpty()){
            cont = cont * nums.pop();
        }
        return cont;
    }

    public double getDecimal() {
        return (this.num / (double)this.den);
    }

    public boolean compararF(Fraccion b) {
        return (this.getDecimal() == b.getDecimal());
    }

    public static int[] generarPrimos(int n){
        int cont = n - 2;
        boolean primos[] = new boolean[n];

        for (int i = 2; i < primos.length; i++) {
            primos[i] = true;
        }

        for (int i = 2; i < primos.length; i++) {
            for (int j = i + 1; j < primos.length && primos[j]; j++) {
                if (j % i == 0) {
                    primos[j] = false;
                    cont--;
                }
            }
        }
        int arr[] = new int[cont];
        int cont2 = 0;
        for (int i = 0; i < primos.length; i++) {
            if (primos[i]) {
                arr[cont2] = i;
                cont2++;
            }
        }
        return arr;
    }

    public Fraccion invertirS() {
        return new Fraccion(-1 * this.num, this.den);
    }

    public String getString() {
        if (this.den == 1) {
            return this.num + "";
        }else if (this.num == 0){
            return "0";
        }
        return this.num + "/" + this.den;
    }

}
package org.koreait;

import java.util.Scanner;

public class Container {
    private static Scanner sc ;

    public static void init(){
        sc = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        return sc;
    }

    public static void close() {
        sc.close();
    }
}
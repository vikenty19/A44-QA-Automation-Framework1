package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Anagramm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two words");
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        char[]strarr1 = str1.toCharArray();
        char[]strarr2 = str2.toCharArray();
        Arrays.sort(strarr1);
        Arrays.sort(strarr2);
        String sortedStr1 = new String(strarr1);
        String sortedStr2 = new String(strarr2);

        System.out.println((Arrays.toString(strarr1)));
        System.out.println((Arrays.toString(strarr2)));
       System.out.println((sortedStr2));
//        if (sortedStr1.equals(sortedStr2)){
//            System.out.println("Anagramm");
//
//        }else {
//            System.out.println("Not Anagramm");
//    }
        if (Arrays.equals(strarr1,strarr2)){
            System.out.println("Anagramm");

        }else {
            System.out.println("Not Anagramm");
        }
}
}

package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Anagramm {
    public static void main(String[] args) {
//        System.out.println(isAnagram("hava","java"));
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter two words");
//        String str1 = scanner.nextLine();
//        String str2 = scanner.nextLine();
//        char[]strarr1 = str1.toCharArray();
//        char[]strarr2 = str2.toCharArray();
//        Arrays.sort(strarr1);
//        Arrays.sort(strarr2);
//        String sortedStr1 = new String(strarr1);
//        String sortedStr2 = new String(strarr2);
//
//        System.out.println((Arrays.toString(strarr1)));
//        System.out.println((Arrays.toString(strarr2)));
//       System.out.println((sortedStr2));
////        if (sortedStr1.equals(sortedStr2)){
////            System.out.println("Anagramm");
////
////        }else {
////            System.out.println("Not Anagramm");
////    }
//        if (Arrays.equals(strarr1,strarr2)){
//            System.out.println("Anagramm");
//
//        }else {
//            System.out.println("Not Anagramm");
//        }

        int[] count = new int[255];
        System.out.println(count['a']);
        count['a']++;
        System.out.println(count['a']);
        int counter=0;
        for(int i=0;i<count.length;i++) {
            System.out.println(counter++ + " " + count[i]);
        }








        } public static boolean isAnagram(String str1, String str2) {

      /*If both strings is of different length,
        then it's not an anagram */
        if(str1.length() != str2.length())
            return false;

        //Create an array of size 256
        int[] countarr = new int[256];
    //   System.out.println(Arrays.toString(countarr));
        for(int i = 0; i < str1.length(); i++) {
            //Increment character count for str1
            System.out.println(str1.charAt(i));
            countarr[str1.charAt(i)]++;
            System.out.println(Arrays.toString(countarr));
            //decrement character count for str2
            countarr[str2.charAt(i)]--;
            System.out.println(str2.charAt(i));
        }
        System.out.println(Arrays.toString(countarr));
        for(int j = 0; j < countarr.length; j++) {
            //if it's not zero
            if( countarr[j] != 0) {
                System.out.println((countarr[j])+j);
                return false;
            }
        }

        return true;
}
}

package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//String reverse
       String example = "Hello world!";
       char[] charArray = example.toCharArray();
       String reverseWord = "";
       for (int i =charArray.length-1;i >=0;i--){
           reverseWord = reverseWord+charArray[i];
       }
        System.out.println(reverseWord);
       //using char

       String word ="Hello!";
       String  result ="";
       for (int i = 0;i < word.length();i++){
            result = word.charAt(i)+ result;
           System.out.println(result);
       }
       //array reverse



     int[] array ={1,2,3,4,5};
        System.out.println(Arrays.toString(array));
       for(int i = 0;i <=array.length/2;i++){
           int temp = array[i];
           array[i]= array[array.length-1-i];
           array[array.length-1-i]= temp;
       }
        System.out.println(Arrays.toString(array));
}
}
package org.example;

import java.util.Arrays;
import java.util.Locale;

public class BubbleSorted {
    public static void main(String[] args) {
        int[]arr = {35,7,6,0,100,5};
        int temp;
        boolean check = false;
        while ((!check)){
            check= true;
            for (int i = 0; i <arr.length-1 ; i++) {
                if(arr[i]>arr[i+1]){
                    temp=arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    check = false;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        //StringBuilder exercise
        StringBuilder sb = new StringBuilder("hello");
        sb.append(" hello!");
        System.out.println(sb);
        System.out.println(sb.deleteCharAt(5));
        System.out.println(sb.reverse());

    }
}

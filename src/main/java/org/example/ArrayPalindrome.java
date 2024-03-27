package org.example;

import dev.failsafe.internal.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPalindrome {
    public static void main(String[] args) {
        ArrayPalindrome task = new ArrayPalindrome();

       int[] arr ={17,23,34,23,17};
      //  int[] arr ={};
        System.out.println(task.isArrayPalindrome(arr));


//        boolean ans = false;
//        int[] rev =new int[arr.length];
//
//
//        for (int i = 0; i < arr.length; i++) {
//
//            rev[i] = arr[arr.length-1-i];
//
//
//        }
//        System.out.println(Arrays.toString(rev));
//        if (Arrays.equals(rev,arr)){
//
//         ans = true;
//
//
//        }
//        System.out.println(ans);
//
//    }


    }
//  Don't work with null!!!!!
    public boolean isArrayPalindrome(int[] arr) {
        boolean ans = true;
        if (arr != null || arr.length != 0) {
            for (int i = 0; i <= arr.length / 2; i++) {
                if (arr[i]!= arr[arr.length - 1 - i]) {
                    ans =false;
                    break;
                }

            }
        }else {ans = false;}
        return ans;


    }
}

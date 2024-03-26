package org.example;

import dev.failsafe.internal.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPalindrome {
    public static void main(String[] args) {
      int[] arr = {17,18,12,9,5,17};

        boolean ans = false;
        int[] rev =new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            rev[i] = arr[arr.length-1-i];


        }
        System.out.println(Arrays.toString(rev));
        if (Arrays.equals(rev,arr)){

         ans = true;


        }
        System.out.println(ans);

    }


}


package org.example;

import java.util.Arrays;
import java.util.List;

public class Task1299 {
    public static void main(String[] args) {
     Task1299 task = new Task1299();
     int[]example = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(task.replaceElement(new int[]{400})));
        System.out.println(Arrays.toString(task.replaceElement(example)));

    }
    public int[] replaceElement(int[]arr){
        int max = -1;
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i]>max){
                max =arr[i];
            }

        }

        return arr;

    }
}

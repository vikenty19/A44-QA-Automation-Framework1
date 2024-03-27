package org.example;

import org.openqa.selenium.json.JsonOutput;

import java.util.Optional;

public class SandBox {
    public static void main(String[] args) {
        int[]array1 = new int[]{1,2,3,100};
        int[]array = new int[]{1};
        System.out.println(searchMax(array));
        System.out.println(findElement(array1,3));
        System.out.println(findElement(array,3));
        System.out.println(findElement(new int[0],3));
    }


    public static Integer searchMax(int[] arr) {
        if(arr == null||arr.length==0){
            return null;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    public static Optional<Integer>findElement(int[]arr,int querry){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==querry){
                return  Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
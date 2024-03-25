package org.example;

import java.util.Optional;

public class FindMax {
    public static void main(String[] args) {
       var array = new int[]{34, 55, 67, 23, 0};
       int[] array1 = null;
//        System.out.println(max(array) + " 67");
//        System.out.println(max(new int[0]) + "  null");
//        System.out.println(max(new int[]{88}) + "  88");
//        System.out.println(max(array1)+ "  null");
//        System.out.println(max(null) + " another null");
        System.out.println(indexFind(array,23) + "3");
        System.out.println(indexFind(array,0) + "4");
        System.out.println(indexFind(array,77) + "  empty");
        System.out.println(indexFind(null,77) + "  empty");

    }

    public static Integer max(int[] arr) {
        if (arr==null||arr.length == 0) {
            return null;
        }
        int maximum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
        }
        return maximum;
    }
    public static Optional<Integer> indexFind(int[]arr,int querry) {
           if(arr==null||arr.length==0){
               return Optional.empty();
           }
        for (int i = 0; i <arr.length ; i++) {
            if(querry==arr[i]){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}

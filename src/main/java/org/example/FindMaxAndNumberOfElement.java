package org.example;

import java.util.Arrays;
import java.util.Optional;

public class FindMaxAndNumberOfElement {
    public static void main(String[] args) {
        var array = new int[]{34,45,17,4,8,198};
        int[] array1 = null;
//        System.out.println(max(array) + " 67");
        //       System.out.println(min(array) + "  0");
        System.out.println(secondMin(array) + "  0");
//        System.out.println(max(new int[]{88}) + "  88");
//        System.out.println(max(array1)+ "  null");
//        System.out.println(max(null) + " another null");
//        System.out.println(firstIndexFind(array,23) + "3");
//        System.out.println(firstIndexFind(array,0) + "4");
//        System.out.println(firstIndexFind(array,77) + "  empty");
//        System.out.println(firstIndexFind(null,77) + "  empty");
        System.out.println(Arrays.toString(array));
        System.out.println(searchMinByNumber((array),7));

    }

    public static Integer max(int[] arr) {
        if (arr == null || arr.length == 0) {
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

    public static Integer min(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int minimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return minimum;
    }

    public static Optional<Integer> firstIndexFind(int[] arr, int querry) {
        if (arr == null || arr.length == 0) {
            return Optional.empty();
        }
        for (int i = 0; i < arr.length; i++) {
            if (querry == arr[i]) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static Integer secondMin(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int min = arr[0];
        int min2 = arr[1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min2 = min;
                min = arr[i];

            } else if (arr[i] < min2 && arr[i] != min2) {
                min2 = arr[i];
            }

        }
        return min2;
    }
    // ищем н-ый максимальный элемент
    public static Integer searchMinByNumber(int[] arr1, int n) throws IndexOutOfBoundsException{

        // сортируем пузырьком
        if (arr1 == null || arr1.length < n ||n <1) {
         //   throw new   IndexOutOfBoundsException("Wrong n or array");
           return null;
        }
        boolean check = false;
        int temp;
        while ((!check)) {
            check = true;

            for (int i = 0; i < arr1.length - 1; i++) {
                if (arr1[i] > arr1[i + 1]) {
                    temp = arr1[i];
                    arr1[i] = arr1[i + 1];
                    arr1[i + 1] = temp;
                    check = false;

                }
            }
           System.out.println(Arrays.toString(arr1));
            // return n-th element
        }return  arr1[arr1.length-n];

    }

}
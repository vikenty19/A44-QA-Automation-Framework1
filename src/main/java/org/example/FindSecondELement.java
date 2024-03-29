package org.example;

public class FindSecondELement {
    // НЕ ЗАКОНЧЕНО!!
    public static int findSecondElement(int[]arr){

        if(arr.length<2){
            throw new IllegalArgumentException("Array size must has more elements");
        }

          int max1 = arr[0];
        int max2 = arr[1];
              for (int i = 2; i < arr.length; i++) {
                  if(arr[i]>max1){
                      max2 = arr[i];
                  }


        } return max2;
    }
}

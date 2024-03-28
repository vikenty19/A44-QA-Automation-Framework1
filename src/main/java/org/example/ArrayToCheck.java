package org.example;

public class ArrayToCheck {
    static void palindrome(int arr[]){

        // Initialise flag to true.
      boolean flag = true;

        // Loop till array size n/2.
        for (int i = 0; i <= arr.length / 2 && arr.length != 0; i++) {

            // Check if first and last element are different
            // Then set flag to false
            if (arr[i] != arr[arr.length- i - 1]) {
                flag = false;
                break;
            }
        }

        // If flag is set then print Not Palindrome
        // else print Palindrome.
        if (flag == false)
            System.out.println("Not Palindrome");
        else
            System.out.println("Palindrome");
    }

    // Driver code.
    public static void main(String[] args)
    {
        int arr[] = {1,2,3,2,1,0};


        palindrome(arr);
    }
}

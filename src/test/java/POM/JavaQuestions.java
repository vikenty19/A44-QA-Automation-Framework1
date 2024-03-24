package POM;

public class JavaQuestions {
     public static void main(String[] args) {

             String song ="abcde";
             char n0 = song.charAt(0);
             char n1 = song.charAt(1);
             String number = new String(new char[]{n0,n1});

             int headerCounter = Integer.parseInt(number);//Bring string to int
             System.out.println("Number of songs in HeaderCounter " +headerCounter);
             //   int num = Character.getNumericValue(number); Bring char to int
             //   System.out.println(num);

         }



    }


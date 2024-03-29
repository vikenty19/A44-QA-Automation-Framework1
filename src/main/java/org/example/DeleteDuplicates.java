package org.example;

public class DeleteDuplicates {
    public static void main(String[] args) {


        String example = "1№***ФФ aaa kk";
        String result = "";
        for (int i = 0; i < example.length(); i++) {
            String ch = ""+(example.charAt(i));
            if(result.contains(ch)){
                continue;
            }
            result +=ch;
        }
        System.out.println(result);

    }
}

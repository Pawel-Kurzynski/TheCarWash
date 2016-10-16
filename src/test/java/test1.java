import java.util.*;
import java.io.*;

class Main {

    public static String SimpleSymbols(String str) {

        String cheacker = "true";

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] charAlphabet = alphabet.toCharArray();
        str = str.toUpperCase();
        int length = str.length();
        String subStr = str.substring(1,length-1);

        for (int i=0; i<length-2; i++) {
            boolean plus = true;

            for (char c:charAlphabet) {
                if (subStr.charAt(i) == c){
                    if (str.charAt(i)== '+'&& str.charAt(i+2) == '+'){
                        plus = true;
                    }else {
                        plus = false;
                        break;
                    }
                }
            }
            if (!plus){
                cheacker = "false";
                break;
            }
        }
        return cheacker;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SimpleSymbols(s.nextLine()));
    }

}








  
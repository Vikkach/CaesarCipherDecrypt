/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarciphedecrypt;

import java.util.HashMap;

/**
 *
 * @author Виктория
 */
public class CaesarCipheDecrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(decrypt("Kh ghwhuplqhg wr gurs klv olwljdwlrq zlwk wkh prqdvwub, dqg uholqjxlvk klv fodlpv wr wkh zrrg-fxwlqj dqg ilvkhub ulkjwv dw rqfh. Kh zdv wkh pruh uhdgb wr gr wklv ehfxdvh wkh uljkwv kdg ehfrp pxfk ohvv ydoxdeoh, dqg kh kdg lqghhg wkh ydjxhvw lghd zkhuh wkh zrrg dqg ulyhu lq txhgwlrq zhuh."));// TODO code application logic here
    }

    
    public static String decrypt(String input){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder replasedString = new StringBuilder(input);
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int j = 0;
        for (int i = 0; i < input.length(); i++){
            char ch = input.toLowerCase().charAt(i);
            if (Character.isAlphabetic(ch) ){
                if (hashmap.containsKey(ch)){
                    int newFreq = hashmap.get(ch) + 1;
                    hashmap.put(ch, newFreq);
                } else
                    hashmap.put(ch, 1);
            }
        }
        char maxChar = 0;
        int max = 0;
        for (int k = 0; k < 26; k++){
            char chAlphK = alphabet.toLowerCase().charAt(k);
            if (hashmap.containsKey(chAlphK)){
                int v1 = hashmap.get(chAlphK);
                if (max < v1){
                    max = v1;
                    maxChar = chAlphK;
                }
            }   
        }
        int indexE = Character.getNumericValue('E');
        int indexMaxChar = Character.getNumericValue(maxChar);
        int key = (indexE - indexMaxChar);
        
         for (int i = 0; i < input.length(); i++){
            char newChar = 0;
            char fromInput = input.charAt(i);
            int oldCharIndex = Character.getNumericValue(fromInput);
            int newCharIndex = oldCharIndex + key;
            if (newCharIndex > 10 && newCharIndex < 36){
               newChar = Character.forDigit(newCharIndex, 36); 
            } else {
                 newChar = Character.forDigit(oldCharIndex, 36);
             }
            //if ((newCharIndex < 0) || (newCharIndex > 35)) {
              //  throw new IllegalArgumentException();
            //}
           
            replasedString.setCharAt(i, newChar);
        }
        return replasedString.toString(); 
    }
    
    
}

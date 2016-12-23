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
        System.out.println(oneKeyDecrypt("iQOS - Analyze 1.6 and 1.7 Charger SCP specs Changes in doc v1.7 are only for System Status command which is not implemented on iOS/Android side, no changes required. In doc v1.6 added flag to Detailed System Error command (for charger), should be implemented in iOS/Android side."));
        System.out.println(twoKeyDecrypt("Just a test string with lots of eeeeeeeeeeeeeeeees"));// TODO code application logic here
    }

    
    public static String oneKeyDecrypt(String input){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder replasedString = new StringBuilder(input);
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < input.length(); i++){
            char ch = input.toLowerCase().charAt(i);
            if (Character.isAlphabetic(ch) ){
                if (hashmap.containsKey(ch)){
                    int newFreq = hashmap.get(ch) + 1;
                    hashmap.put(ch, newFreq);
                } else {
                    hashmap.put(ch, 1);
                }
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
                if (Character.isLowerCase(fromInput)){
                    newChar = Character.forDigit(newCharIndex, 36);
                } if (Character.isUpperCase(fromInput)){
                    newChar = Character.forDigit(newCharIndex, 36);
                    newChar = Character.toUpperCase(newChar);
                }
            } else {
                newChar = Character.valueOf(fromInput);
             }
           
            replasedString.setCharAt(i, newChar);
        }
        return replasedString.toString(); 
    }
    
     public static String twoKeyDecrypt(String input){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder replasedString = new StringBuilder(input);
        HashMap<Character, Integer> firstKeyHashmap = new HashMap<>();
        HashMap<Character, Integer> secondKeyHashmap = new HashMap<>();
        
        for (int i = 0; i < input.length(); i++){
            if (i%2 == 0){
                char ch = input.toLowerCase().charAt(i);
                if (Character.isAlphabetic(ch) ){
                    if (firstKeyHashmap.containsKey(ch)){
                        int newFreq = firstKeyHashmap.get(ch) + 1;
                        firstKeyHashmap.put(ch, newFreq);
                    } else {
                        firstKeyHashmap.put(ch, 1);
                    }
                }
            } if (i%2 != 0){
                char ch = input.toLowerCase().charAt(i);
                if (Character.isAlphabetic(ch) ){
                    if (secondKeyHashmap.containsKey(ch)){
                        int newFreq = secondKeyHashmap.get(ch) + 1;
                        secondKeyHashmap.put(ch, newFreq);
                    } else {
                        secondKeyHashmap.put(ch, 1);
                    }
                }
            }
        }
        
        char maxCharKey1 = 0;
        int maxKey1 = 0;
        char maxCharKey2 = 0;
        int maxKey2 = 0;
        for (int k = 0; k < 26; k++){
            char chAlphK = alphabet.toLowerCase().charAt(k);
            if (firstKeyHashmap.containsKey(chAlphK)){
                int v1 = firstKeyHashmap.get(chAlphK);
                if (maxKey1 < v1){
                    maxKey1 = v1;
                    maxCharKey1 = chAlphK;
                }
                } if (secondKeyHashmap.containsKey(chAlphK)){
                    int v1 = secondKeyHashmap.get(chAlphK);
                    if (maxKey2 < v1){
                        maxKey2 = v1;
                        maxCharKey2 = chAlphK;
                    }
                }
        }
        
        int indexE = Character.getNumericValue('E');
        int indexMaxCharKey1 = Character.getNumericValue(maxCharKey1);
        int indexMaxCharKey2 = Character.getNumericValue(maxCharKey2);
        int key1 = (indexE - indexMaxCharKey1);
        int key2 = (indexE - indexMaxCharKey2);
        
        for (int i = 0; i < input.length(); i++){
            char newChar = 0;
            char fromInput = input.charAt(i);
            if (i%2 == 0){
                int oldCharIndex = Character.getNumericValue(fromInput);
                int newCharIndex = oldCharIndex + key1;
                if (newCharIndex > 10 && newCharIndex < 36){
                    if (Character.isLowerCase(fromInput)){
                        newChar = Character.forDigit(newCharIndex, 36);
                    } if (Character.isUpperCase(fromInput)){
                        newChar = Character.forDigit(newCharIndex, 36);
                        newChar = Character.toUpperCase(newChar);
                    }
                } else {
                    newChar = Character.valueOf(fromInput);
                }
            }
            
            if (i%2 != 0){
                int oldCharIndex = Character.getNumericValue(fromInput);
                int newCharIndex = oldCharIndex + key2;
                if (newCharIndex > 10 && newCharIndex < 36){
                    if (Character.isLowerCase(fromInput)){
                        newChar = Character.forDigit(newCharIndex, 36);
                    } if (Character.isUpperCase(fromInput)){
                        newChar = Character.forDigit(newCharIndex, 36);
                        newChar = Character.toUpperCase(newChar);
                    }
                } else {
                    newChar = Character.valueOf(fromInput);
                }
            }
           
            replasedString.setCharAt(i, newChar);
        }
        return replasedString.toString();
     }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarciphedecrypt;

import java.util.Collections;
import java.util.HashMap;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author Виктория
 */
public class CaesarCipheDecrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(decrypt("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu"));// TODO code application logic here
    }
    public static String decrypt(String input){
        StringBuilder replasedString = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
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
        int indexE = alphabet.indexOf('E');
        int indexMaxChar = alphabet.indexOf(Character.toUpperCase(maxChar));
        int key = (indexMaxChar - indexE);
        
        String shiftAphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
         for (int i = 0; i < input.length(); i++){
            char fromInput = input.charAt(i);
            for (int l = 0; l < shiftAphabet.length(); l++){
                char fromAlph = shiftAphabet.charAt(l);
                char fromAlphLow = shiftAphabet.toLowerCase().charAt(l);
                if (fromInput == fromAlph){
                    char newCH = alphabet.charAt(l);
                    replasedString.setCharAt(i, newCH);
                } else if (fromInput == fromAlphLow){
                    char newCH = alphabet.toLowerCase().charAt(l);
                    replasedString.setCharAt(i, newCH);
                }
            }
        }
        return replasedString.toString(); 
    }
    
    
}


/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class CaesarCipher {
    
   public String  encrypt(String input, int key){
       
       StringBuilder encrypted= new StringBuilder(input);
       
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String shiftedString = alphabet.substring(key) + alphabet.substring(0,key);
       for (int i=0 ; i<input.length(); i++){
           
           char currChar = encrypted.charAt(i);
           int idx = alphabet.indexOf(Character.toUpperCase(currChar));
           
           if(idx != -1){
               if(Character.isUpperCase(currChar)){
                   char newChar = Character.toUpperCase(shiftedString.charAt(idx));
                   encrypted.setCharAt(i,newChar);
                }
               else{
                   char newChar = Character.toLowerCase(shiftedString.charAt(idx));
                   encrypted.setCharAt(i,newChar);
                }
               
               
            }
           
       }       
       return (encrypted.toString());
       
       
    }
    
    
   public void testCaesar(){
    //FileResource fr = new FileResource();
    //String message = fr.asString();
    int key = 23;
    String encrypted = encrypt("First Legion", 23);
    System.out.println("key is " + key + "\n" + encrypted);
   }
   
   
   
   public String encryptTwoKeys(String input, int key1, int key2){
       
       
       StringBuilder encrypted= new StringBuilder(input);
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String shiftedStringkey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
       String shiftedStringkey2 = alphabet.substring(key2) + alphabet.substring(0,key2);
       for (int i=0 ; i<input.length(); i++){
           
           char currChar = encrypted.charAt(i);
           int idx = alphabet.indexOf(Character.toUpperCase(currChar));
           
           if (i%2 == 0){
           if(idx != -1){
               if(Character.isUpperCase(currChar)){
                   char newChar = Character.toUpperCase(shiftedStringkey1.charAt(idx));
                   encrypted.setCharAt(i,newChar);
                }
               else{
                   char newChar = Character.toLowerCase(shiftedStringkey1.charAt(idx));
                   encrypted.setCharAt(i,newChar);
                }
               
               
            }
        }
        else{
              if(idx != -1){
               if(Character.isUpperCase(currChar)){
                   char newChar = Character.toUpperCase(shiftedStringkey2.charAt(idx));
                   encrypted.setCharAt(i,newChar);
                }
               else{
                   char newChar = Character.toLowerCase(shiftedStringkey2.charAt(idx));
                   encrypted.setCharAt(i,newChar);
                }
               
               
            }
        }
           
       }       
       return (encrypted.toString());
    }
    
    
    public void encryptTwoKeys(){
    //FileResource fr = new FileResource();
    //String message = fr.asString();
    String encrypted = encryptTwoKeys("First Legion", 23,17);
    System.out.println("key is " + "\n" + encrypted);
}
   
}

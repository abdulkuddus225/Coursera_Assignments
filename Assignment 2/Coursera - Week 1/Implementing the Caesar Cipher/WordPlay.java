
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.*;
public class WordPlay {
    
    public boolean isVowel(char ch){
        if (ch == 'a' ||
        ch == 'e' ||
        ch == 'i' ||
        ch == 'o' ||
        ch == 'u' ||
        ch == 'A' ||
        ch == 'E' ||
        ch == 'I' ||
        ch == 'O' ||
        ch == 'U'){
            return true;
        }
        return false;
    }
    
    public void testVowel(){
        System.out.println("The character is Vowel? " +isVowel('b'));
    }
    
    public String replaceVowels(String phrase, char ch){
        
        StringBuilder str = new StringBuilder();
        str.append(phrase);
        
        for (int i=0 ; i<str.length(); i++){
            if(isVowel(str.charAt(i))){
                str.setCharAt(i,ch);
            }
        }
        
        return (str.toString());
    }
    
    public void testreplaceVowel(){
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    public String emphasize(String phrase, char ch){
        
        StringBuilder str = new StringBuilder();
        str.append(phrase);
        char upperCase = Character.toUpperCase(ch);
        char lowerCase = Character.toLowerCase(ch);   
        
        
        for (int i=0 ; i<str.length(); i++){
            
            if(str.charAt(i) == upperCase || str.charAt(i) == lowerCase){
            
                    if((i+1) % 2 == 0){
                        str.setCharAt(i, '+');
                    }
                    
                    else{
                        str.setCharAt(i, '*');
                    }
            }
            
        }
        return (str.toString());
    }
    public void testemphasize(){
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}

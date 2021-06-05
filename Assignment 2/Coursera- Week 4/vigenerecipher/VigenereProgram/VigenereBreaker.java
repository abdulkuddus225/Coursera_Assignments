import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String slicedString = "";
        for (int i=whichSlice; i<message.length();){
                
                slicedString += message.charAt(i);
                i += totalSlices;
        }
        return slicedString;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker ccr = new CaesarCracker(mostCommon);
        for(int i=0; i<klength; i++){
            String s = sliceString(encrypted, i, klength);
            int a = ccr.getKey(s);
            key[i] = a;
        }
        
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String content = fr.asString();
        FileResource eng = new FileResource();
        HashSet<String> dictContent = new HashSet<String>();
        dictContent = readDictionary(eng);
        String decrypted = breakForLanguage(content, dictContent);
        System.out.print(decrypted);
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        
        HashSet<String> words = new HashSet<String>();
        
        for(String s: fr.words()){
            s = s.toLowerCase();
            words.add(s);
        }
        
        return words;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
            
        int count = 0;
        String[] split = message.split("\\W+");
        for(String word: split){
            word = word.toLowerCase();
            if(dictionary.contains(word)){
                count++;
            }
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        
        int largestCount = 0;
        StringBuilder decrypted = null;
        
        for(int i=1; i<=100; i++){
            int[] keys = tryKeyLength(encrypted, i, 'e');
            VigenereCipher vc = new VigenereCipher(keys);
            decrypted =  new StringBuilder(vc.decrypt(encrypted));
            int count = countWords(decrypted.toString(), dictionary);
            if (count > largestCount){
                count = largestCount;
            }
         
        }
        System.out.println("Number of words " +largestCount);
        
        return decrypted.toString();
    }
}

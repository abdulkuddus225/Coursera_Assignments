
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class WordLengths {

    
   
    
    public void countWordLengths(FileResource resource, int[] counts){
        
        for (String s: resource.words()){
            int index = s.length();
            if (Character.isLetter(s.charAt(0)) == false){
                index -= 1;
            }
            if (Character.isLetter(s.charAt(s.length() - 1)) == false){
                index -= 1;
            }
            if (index < 0){
                continue;
            }
            counts[index] ++;
        }
    }
    
    public int indexOfMax(int[] values){
        
        int largestElement = 0;
        int index = 0;
        for (int i: values){
            
            if(values[i] > largestElement){
                largestElement = values[i];
                index++;
            }
        }
        
        return index;
    }
    
    public void testcountWords(){
        FileResource a = new FileResource();
        int[] counts = new int[50];
        countWordLengths(a, counts);
        for (int i = 0; i < 31; i ++){
            if (counts[i] != 0){
                System.out.println(counts[i] + " words of length " + i);
            }
        }
       System.out.println(indexOfMax(counts));
    
    }
}

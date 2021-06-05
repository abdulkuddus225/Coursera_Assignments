
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    
    public boolean twoOccurrences(String stringa, String stringb){
        
        int count = 0;
        int lastIndex = 0;
        while (lastIndex != -1){
            
            lastIndex = stringb.indexOf(stringa,lastIndex);
            
            if (lastIndex != -1){
                count++;
                lastIndex += stringa.length();
            }
        }
        
        if (count >= 2){
            return true;
        }
        return false;
    }
    
    public void testingtwoOccurrences(){
        System.out.println("Is there two occurrences of stringa in stringb? "+ twoOccurrences("by", "A story by Abby Long"));
        System.out.println("Is there two occurrences of stringa in stringb? "+ twoOccurrences("a", "banana"));
        System.out.println("Is there two occurrences of stringa in stringb? "+ twoOccurrences("atg", "ctgtatgta"));
        
    }
    
    public String lastPart(String stringa, String stringb){
        String partremaining = "";
        int firstOccurrence = stringb.indexOf(stringa);
        if (firstOccurrence != -1){
            partremaining = stringb.substring(firstOccurrence+stringa.length(), stringb.length());
            return partremaining;
        }
        return stringb;
    }
    
    public void testinglastPart(){
        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("zoo", "forest")); 
    }
}

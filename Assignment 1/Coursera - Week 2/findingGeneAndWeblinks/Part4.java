
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class Part4 {

    
    URLResource url = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    
    public void findlinks(){
        int leftquote;
        int rightquote;
        String youtubelink = "";
        for (String word : url.words()){
            
            word  = word.toLowerCase();
            if (word.contains("youtube.com")){
                leftquote = word.indexOf("\"");
                rightquote = word.lastIndexOf("\"");
                youtubelink = word.substring(leftquote+1,rightquote);
                System.out.println(youtubelink);
            }
        }
    }
}


/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.*;

public class BabyNames {

    public void  totalBirths(){
        
        int totalBirths = 0;
        int girlsName = 0;
        int boysName = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord csvData: parser){
            
            if (csvData.get(1).contains("M")){
                boysName += Integer.parseInt(csvData.get(2));
            }
            else{
                girlsName += Integer.parseInt(csvData.get(2));
            }
            
        }
        
        totalBirths = girlsName + boysName;
        
        System.out.println("Number of Boys names are "+ boysName);
        System.out.println("Number of Girls names are "+ girlsName);
        System.out.println("Total Number  names are "+ totalBirths);
    }
    
    public void testTotalBirths(){
        totalBirths();
    }
    
    public int getRank(int year, String name, String gender){
    
        int rank = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord csvData: parser){
            if(csvData.get(1).equals(gender)){
                rank++;
                if(csvData.get(0).equals(name)){
                    return rank;
                }
            }
            
            
        }
        return -1;
        
    }
    
    public void testgetRank(){
        
        System.out.println("Rank of the name is "+ getRank(2012, "Mason", "M"));
    }
    
    public String getName(int year,int rank, String gender){
        
        int count = 1;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        
        for (CSVRecord csvData: parser){
            if(csvData.get(1).equals(gender)){
                
                if (count == rank){
                    return csvData.get(0);
                }
                count++;
            }
        }
        return "No Name";
    }
    
    public void testgetName(){
        
        System.out.println(getName(2012, 2, "M"));
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
    
        int rank = getRank(year, name, gender);
        String nameNew = getName(year,rank, gender);
        
        System.out.println(name + " born in "+ year + " would be " + nameNew + " if she was born in " + newYear);
    }
    
    public void testwhatIsNameInYear(){
            whatIsNameInYear("Isabella", 2012, 2014, "F");
    }
    
    public int yearOfHighestRank(String name, String gender){
        
        DirectoryResource dr = new DirectoryResource();
        int highestRank = 0;
        String yob = null;
        int year = 0;
        int highestYear = 0;
        for (File f:dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String fName = f.getName();
            yob = fName.substring(3,7);
            year = Integer.parseInt(yob);
            int currentRank = getRankForHighestRank(year,name, gender,fr);
            System.out.println(currentRank);
            if (highestRank == 0) {
                
                highestRank = currentRank;
                highestYear = year;
            }
            if (currentRank != -1) {
                if (highestRank > currentRank) {
                    highestRank = currentRank;
                    highestYear = year;
                }
            }  
            else {
                return -1;
            }
        }
        return highestYear;
    }
    
    public int getRankForHighestRank(int year, String name, String gender, FileResource fr) {
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        for (CSVRecord rec : parser) {
            if (rec.get(1).equals(gender)) {
                rank += 1;
                if (rec.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }
    
    public void testyearHighestRank(){
        System.out.println(yearOfHighestRank("Mason", "M"));
    }
    
    public double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        String yob = null;
        int year = 0;
        double averageRank = 0.0;
        int totalRank = 0;
        int counter = 0;
        for (File f:dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String fName = f.getName();
            yob = fName.substring(3,7);
            year = Integer.parseInt(yob);
            int currentRank = getRankForHighestRank(year,name, gender,fr);
            totalRank += currentRank;
            counter++;
        }
        if(totalRank > 0){
            averageRank = totalRank/counter;
            return averageRank;
        }
        
        return -1;
    }
    
    public void testgetAverageRank(){
        System.out.println("Average Rank is "+ getAverageRank("Mason", "M"));
    }
}


/**
 * Write a description of ColdestDay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class ColdestDay {

    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestTemp = null;
        
        for (CSVRecord currentRow:parser){
            
            if(coldestTemp == null){
                coldestTemp = currentRow;
            }
            else{
                coldestTemp = comparision(currentRow, coldestTemp, "TemperatureF");
                
            }
        }
        
        
        return coldestTemp;
    }
    
    public void testColdestHourInFile(){
        FileResource csvData = new FileResource();
        CSVRecord parser = coldestHourInFile(csvData.getCSVParser());
        System.out.println("Coldest temperature is " + parser.get("TemperatureF") + " at " + parser.get("DateUTC"));
    }
    
    public String fileWithColdestTemperature(){
        CSVRecord coldestTemp = null;
        String filename = "";
        
        DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
             FileResource csvData = new FileResource(f);
             CSVRecord parser = coldestHourInFile(csvData.getCSVParser());
             if (coldestTemp == null){
                 coldestTemp = parser;
                }
                

            else{
                
                double curColdesttemp = Double.parseDouble(parser.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(coldestTemp.get("TemperatureF"));
                
                if (curColdesttemp < smallestTemp){
                    coldestTemp = parser;
                    filename = f.getName();
                }
                
            }
         }  
       
         
       return filename;
     }
     
     public void testFileWithColdestTemperature(){
        String filename = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " +filename);
        String filepath = "/Users/abdulkuddus/java_coursera/maximum_temperature/nc_weather/2014/" +filename;
        FileResource csvData = new FileResource(filepath);
        CSVRecord parser = coldestHourInFile(csvData.getCSVParser());
        System.out.println("Coldest temperature is " + parser.get("TemperatureF") + " at " + parser.get("DateUTC"));
        
    }
    
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        
        CSVRecord lowestHumidity = null;
        
        
        for (CSVRecord currRow: parser){
            if (lowestHumidity == null){
                lowestHumidity = currRow;
            }
            
            else{
                if(currRow.get("Humidity").contains("N/A") == false){
                
                lowestHumidity = comparision(currRow, lowestHumidity,"Humidity");
            }
            }
            
        }
        
        
        return lowestHumidity;
        
        
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was "+ csv.get("Humidity")+ " at " +csv.get("DateUTC"));
    }
     
    public CSVRecord comparision(CSVRecord currRow, CSVRecord lowest, String column){


        double curColdesttemp = Double.parseDouble(currRow.get(column));
        double smallestTemp = Double.parseDouble(lowest.get(column));
                
        if (curColdesttemp < smallestTemp){
                    lowest = currRow;
        }
        return lowest;
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHumidity = null;
        
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
             FileResource csvData = new FileResource(f);
             CSVRecord parser = lowestHumidityInFile(csvData.getCSVParser());
             if (lowestHumidity == null){
                 lowestHumidity = parser;
                }
                

            else{
                
                double curColdesttemp = Double.parseDouble(parser.get("Humidity"));
                double smallestTemp = Double.parseDouble(lowestHumidity.get("Humidity"));
                
                if (curColdesttemp < smallestTemp){
                    lowestHumidity = parser;
                }
                
            }
         }  
        
        return lowestHumidity;
    }
    
    public void testLowestHumidityInManyFiles(){

        CSVRecord parser = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + parser.get("Humidity") + " at " + parser.get("DateUTC"));
    }
    
    
    public double averageTemperatureInFile(CSVParser parser){
        
        int count = 0;
        double totalTemperature = 0;
        double averageTemperature = 0.0;
        for (CSVRecord currentRow: parser){
            totalTemperature += Double.parseDouble(currentRow.get("TemperatureF"));
            count++;
        }
        averageTemperature = (totalTemperature)/(count);
        return averageTemperature;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemprature = averageTemperatureInFile(parser);
        System.out.println("Average Temperature is "+averageTemprature);
    }
    
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        int count = 0;
        double totalTemperature = 0;
        double averageTemperature = 0.0;
        for (CSVRecord currentRow: parser){
            int currentHumidity = Integer.parseInt(currentRow.get("Humidity"));
            
            if (currentHumidity >= value){
                totalTemperature += Double.parseDouble(currentRow.get("TemperatureF"));
                count++;
            }
            
        }
        averageTemperature = (totalTemperature)/(count);
        return averageTemperature;
        
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemprature = averageTemperatureWithHighHumidityInFile(parser, 80);
        System.out.println(averageTemprature);
        if (averageTemprature > 0.0)
            
            System.out.println("Average Temp when high Humidity is "+averageTemprature);
        
        else
            System.out.println("No temperatures with that humidity");
            
    }
}
    

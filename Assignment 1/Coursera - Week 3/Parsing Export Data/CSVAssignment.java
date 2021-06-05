
/**
 * Write a description of CSVAssignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class CSVAssignment {

    
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    
    public String countryInfo(CSVParser parser, String country){
    
        String info = "";
    for (CSVRecord record : parser) {
       String colCountry = record.get("Country");
       if (colCountry.contains(country)){
           info += colCountry+": "+ record.get("Exports")+ ": " + record.get("Value (dollars)");
        }
       
    } 
        
        
        return info;
    }
    
    public void testcountryinfo(){
        System.out.println(countryInfo(parser, "Nauru"));
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        
        for(CSVRecord record : parser){
            if (record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
        
    }
    
    public void testexport(){
        listExportersTwoProducts(parser, "gold", "diamonds");
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        
        for (CSVRecord record : parser){
            if(record.get("Exports").contains(exportItem)){
                count++;
            }
        }
        return count;
        
    }
    
    public void testnumberofE(){
        System.out.println(numberOfExporters(parser,"gold"));
    }
    
    
    public void bigExporters(CSVParser parser, String amount){
        
        for (CSVRecord record : parser){
            if (record.get("Value (dollars)").length() > amount.length()){
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    }
    
    public void testbigexport(){
        bigExporters(parser, "$999,999,999,999");
    }
}

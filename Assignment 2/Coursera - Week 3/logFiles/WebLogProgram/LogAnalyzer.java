
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         
         FileResource fr = new FileResource();
         
         for (String  s: fr.lines()){
            LogEntry le = WebLogParser.parseEntry(s);
            records.add(le);
            
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         
         ArrayList<String> uniqueIPAddress = new ArrayList<String>();
         for (LogEntry s : records){
             String ip = s.getIpAddress();
             if(!uniqueIPAddress.contains(ip)){
                 uniqueIPAddress.add(ip);
             }
            }
         return (uniqueIPAddress.size());
      }
     
     public void printAllHigherThanNum(int num){
     
         for(LogEntry s: records){
            if(s.getStatusCode() > num){
            System.out.println(s);
            }
          }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         
         ArrayList<String> somedayIPAddress = new ArrayList<String>();
         for(LogEntry s: records){
            String d = s.getAccessTime().toString();
           
            if (d.contains(someday)){
                if (!somedayIPAddress.contains(d)){
                    somedayIPAddress.add(d);
                }
            }
         }
         return somedayIPAddress;
     }
     
     public int countUniqueIPsInRange(int low, int high){
         
         ArrayList<String> uniqueIP = new ArrayList<String>();
         for(LogEntry s: records){
             String ip = s.getIpAddress();
             if(s.getStatusCode() >= low && s.getStatusCode() <= high){
                if(!uniqueIP.contains(ip)){
                    uniqueIP.add(ip);
                }
              }
         }
         return uniqueIP.size();
         
        }
     public HashMap<String, Integer> countVisitsPerIP(){
         HashMap<String, Integer> mapIP = new HashMap<String, Integer>();
         
         for(LogEntry s: records){
             String ip = s.getIpAddress();
             if(mapIP.containsKey(ip)){
                mapIP.put(ip, mapIP.get(ip) + 1);
                }
             else{
                 mapIP.put(ip,1);
                }
         }
         return mapIP;
         
     }
    public int mostNumberVisitsByIP(HashMap<String, Integer> visits){
            
        int maxVisit = 0;
        String maxVisitIP = "";
        
        for(HashMap.Entry v: visits.entrySet()){
            String key = (String)v.getKey();
            int value = (int)v.getValue();
            if (value > maxVisit){
                maxVisit = value;
                maxVisitIP = key;
            }
        }
        return maxVisit;
    }
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> iPsForDays = new HashMap<String, ArrayList<String>>();
        
        for (LogEntry s: records){
            String d = s.getAccessTime().toString().substring(4,10);
            String ip = s.getIpAddress();
            if(iPsForDays.get(d) == null){
                iPsForDays.put(d, new ArrayList<String>());
            }
            else{
                iPsForDays.get(d).add(ip);
            }
            
        }
        return iPsForDays;
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> ipsfordays){
        

        int mostVisits = 0;
        StringBuilder str = null;
        for(HashMap.Entry<String, ArrayList<String>> v: ipsfordays.entrySet()){
                
            if(v.getValue().size() > mostVisits){
                mostVisits = v.getValue().size();
                str = new StringBuilder();
                str.append(v.getKey());
            }
        }
       
        return str.toString();
    }
   
}


/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    
    public void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPs());
    }
    
    public void testHigherThen(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAllHigherThanNum(200);
    }
    
    public void testuniqueIPVisitsOnDay(){
        ArrayList<String> result = new ArrayList<String>();
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        result = la.uniqueIPVisitsOnDay("Sep 14");
        System.out.println(result.size());
        for(String s: result){
            System.out.println(s);
        }
    }
    
    public void testUniqueIPInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPsInRange(200,299));
    }
    
    public void testcountVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        for(HashMap.Entry elements: counts.entrySet()){
            String key = (String)elements.getKey();
            int value = (int)elements.getValue();
            System.out.println(key+" , " + value);
        }
        
    }
    
    public void testmostNumberVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        int count = la.mostNumberVisitsByIP(counts);
        System.out.println("Most Number of counts to an IP "+ count);
    }
    public void testiPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String, ArrayList<String>> ipsfordays = la.iPsForDays();
        for(HashMap.Entry<String, ArrayList<String>> elements: ipsfordays.entrySet()){
            
            System.out.println(elements.getKey() + " " + elements.getValue());
        }
    }
    
    public void testdayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String, ArrayList<String>> ipsfordays = la.iPsForDays();
        String output = la.dayWithMostIPVisits(ipsfordays);
        System.out.println(output);
    }

}


/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    
    public int findStopCodon(String dna, int startindex, String stopcodon){
        
        int firstoccurence;
        firstoccurence = dna.indexOf(stopcodon,startindex+3);
        if ((startindex+firstoccurence) % 3 == 0){
            return firstoccurence;
        }
        
        return -1;
    }
    
    public void testFindStopCodon(){
        System.out.println(findStopCodon("ATGGHYTAA", 0, "TAA"));
    }
    
    
    public String findGene(String dna){
        int startcodon;
        int stopcodonTAA;
        int stopcodonTAG;
        int stopcodonTGA;
        int closestcodon = 0;
        String gene = "";
        startcodon = dna.indexOf("ATG");
        if (startcodon == -1){
            return "";
        }
        
        stopcodonTAA = findStopCodon(dna, startcodon, "TAA");
        stopcodonTAG = findStopCodon(dna, startcodon, "TAG");
        stopcodonTGA = findStopCodon(dna, startcodon, "TGA");
        
        if (stopcodonTAA < 0 && stopcodonTAG < 0 && stopcodonTGA < 0){
            return "";
        }
        else if (stopcodonTAA < 0 && stopcodonTAG < 0 ){
                closestcodon = 
        }
        return gene;
    }
}

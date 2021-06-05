
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna){
        int startCodon = dna.indexOf("ATG");
        String gene = "";
        if (startCodon == -1){
            return "";
        }
        
        int stopCodon = dna.indexOf("TAA", startCodon+3);
        if (stopCodon == -1){
            return "";
        }
        
        if (((stopCodon+3)-(startCodon+3)) % 3 == 0 ) {
			
            gene = dna.substring(startCodon, stopCodon+3);
            return gene;
	}
        
	return "";
    }
    
    public void testSimpleGene(){
        
        System.out.println("Gene is " + findSimpleGene("ATGTHEIBTAA")); //DNA with ATG and TAA and not multiple of 3
        System.out.println("Gene is " + findSimpleGene("ATGTHEIBG")); // DNA with ATG and no TAA
        System.out.println("Gene is " + findSimpleGene("THEIBGTAA")); // DNA with no ATG but TAA
        System.out.println("Gene is " + findSimpleGene("THEIBG")); // No ATG and TAA
        System.out.println("Gene is " + findSimpleGene("ATGTHEIBGTAA")); // DNA with ATG TAA and multiple of 3
        
    }
    
    
    
}


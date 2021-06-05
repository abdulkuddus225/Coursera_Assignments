
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String findSimpleGene(String dna, int startCodon, int stopCodon){
        String gene = "";
        if (startCodon == -1){
            return "";
        }
        
        if (stopCodon == -1){
            return "";
        }
        
        if (((stopCodon)-(startCodon)) % 3 == 0 ) {
			
            gene = dna.substring(startCodon, stopCodon+3);
            return gene;
	}
        
	return "";
    }
    
    public void testSimpleGene(){
        
        System.out.println("Gene is " + findSimpleGene("ATGTHEIBTAA", 0, 8)); //DNA with ATG and TAA and not multiple of 3
        System.out.println("Gene is " + findSimpleGene("ATGTHEIBG",0, -1)); // DNA with ATG and no TAA
        System.out.println("Gene is " + findSimpleGene("THEIBGTAA", -1 , 6)); // DNA with no ATG but TAA
        System.out.println("Gene is " + findSimpleGene("THEIBG", -1, -1)); // No ATG and TAA
        System.out.println("Gene is " + findSimpleGene("ATGTHEIBGTAA", 0, 9)); // DNA with ATG TAA and multiple of 3
        
    }
    
}

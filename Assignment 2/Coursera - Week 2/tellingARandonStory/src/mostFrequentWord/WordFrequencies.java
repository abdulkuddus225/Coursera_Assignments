package mostFrequentWord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class WordFrequencies {

	private ArrayList<String> myWords;
	private ArrayList<Integer> 	myFreqs;
	
	public WordFrequencies() {
		
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
		
	}
	
	
	public void findUnique () throws IOException {
		
		
		String line;
		String[] words = null;
		myWords.clear();
		myFreqs.clear();
		
		try (
			    InputStream fis = new FileInputStream("/Users/abdulkuddus/Java Programming/tellingARandonStory/test.txt");
			    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			    BufferedReader br = new BufferedReader(isr);
			) {
			    while ((line = br.readLine()) != null) {
			        // Do your thing with line
			    	words = line.split(" ");
			    }
			}
		
		for(String word : words) {
			
			
			word = word.toLowerCase();
			int index = myWords.indexOf(word);
			
			if(index == -1) {
				myWords.add(word);
				myFreqs.add(1);
			}
			else {
				int value = myFreqs.get(index);
				myFreqs.set(index, value+1);
			}
			
		}
		
		for(int i=0; i<myWords.size(); i++) {
			System.out.println("Counts of word " + myWords.get(i) + " " + myFreqs.get(i));
		}
		
		
		
	}
	
	public int findIndexOfMax() {
		int largest = 0;
		
		for(int i: myFreqs) {
			
			if (i > largest) {
				largest = i;
			}
		}
		return largest;
		
	}
	
}

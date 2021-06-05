package mostFrequentWord;

import java.io.IOException;

public class MostFrequentWord {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WordFrequencies test1 = new WordFrequencies();
		test1.findUnique();
		System.out.println("The word that occurs most often and its count are " + test1.findIndexOfMax());
	}

}

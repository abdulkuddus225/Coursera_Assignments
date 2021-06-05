package decryptingCaeserCipher;

public class CountingOccurrences {
	
	public int[] countOccurrences(String message) {
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
		
		for (int i=0; i<message.length(); i++) {
			
			char ch = Character.toLowerCase(message.charAt(i));
			int inalpha = alpha.indexOf(ch);
			if(inalpha != -1) {
				counts[inalpha] += 1;
			}
		}
		return counts;
	}
	
	public int indexOfMax(int[] values){
        
        int largestElement = 0;
        int index = 0;
        for (int i: values){
            
            if(values[i] > values[largestElement]){
                largestElement = i;
                index++;
            }
        }
        
        return index;
    }
	
	public String decrypt(String encrypted) {
		
		EncryptingCaeserCipher dec = new EncryptingCaeserCipher();
		int[] freq = countOccurrences(encrypted);
		int maxIndex = indexOfMax(freq);
		int dkey = maxIndex - 4;
		if(maxIndex < 4 ) {
			
			dkey = 26 - (4-maxIndex);
		}
		return dec.encrypt(encrypted, 26-dkey);
		
		
	}
	
	public String halfOfString(String message, int start) {
		
		String halfString = "";
		for (int i=start; i<message.length(); i++) {
			halfString += message.charAt(i);
			i++;
		}
		return halfString;
		
	}
	
	public int getKey(String s) {
		
		int key;
		int[] freq = countOccurrences(s);
		key = indexOfMax(freq);
		return key;
		
	}	
	
	public String decryptTwoKeys(String encrypted) {
		
		EncryptingCaeserCipher dec = new EncryptingCaeserCipher();
		String message1 = halfOfString(encrypted, 0);
		String message2 = halfOfString(encrypted, 1);
		
		int key1 = getKey(message1);
		int key2 = getKey(message2);
		int dkey1 = key1 - 4;
		int dkey2 = key2 - 4;
		if(dkey1 < 4) {
			dkey1 = 26 - (4-dkey1);
		}
		if(dkey2 < 4) {
			
			dkey2 = 26 - (4-dkey2);
		}
		
		return dec.encryptTwoKeys(encrypted, dkey1, dkey2);
		
	}
}

package decryptingCaeserCipher;

public class DecryptingCaeserCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingOccurrences co = new CountingOccurrences();
		EncryptingCaeserCipher enc = new EncryptingCaeserCipher();
		String encrypted = enc.encryptTwoKeys("First Legion", 23, 17);
		String decrypted = co.decryptTwoKeys(encrypted);
		System.out.println(encrypted);
		System.out.println(decrypted);
		
	}

}

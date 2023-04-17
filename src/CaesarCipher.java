
public class CaesarCipher extends Cipher {
	private final static int NUM_LETTERS = 26;
	private int shiftAmount;//changed from final b/c wouldn't initiate properly.

	/**
	 * @param amt - the distance to shift letters when encrypting
	 */
	public CaesarCipher(int amt){
		shiftAmount = amt;
	}

	public CaesarCipher(CaesarCipher other){
		this.shiftAmount = other.getShiftAmount();
	}

	public int getShiftAmount() {
		return shiftAmount;
	}


	public char encrypt(char c) {
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');
			// c - base is the index in the alphabet: 'a' becomes 0, 'b' becomes 1, etc.
			return (char)(base + ((c - base + shiftAmount) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}


	public char decrypt(char c) {
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');
			return (char)(base + ((c - base - shiftAmount + NUM_LETTERS) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}


    // Returns a new object, a deep copy of the current object

	public Cipher newCopy() {
		CaesarCipher giveBack = new CaesarCipher(this.shiftAmount);
		return giveBack;
	}

}

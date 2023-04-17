import java.util.ArrayList;

public class VigenereCipher extends Cipher{

	private ArrayList<CaesarCipher> subCiphers;

	// These variables keep track of which
	//  CaesarCipher to use for the next encrypt
	//  or decrypt operation, respectively.
	private int nextIndexForEncrypt;
	private int nextIndexForDecrypt;

    public int getNextIndexForDecrypt() {
        return nextIndexForDecrypt;
    }

    public ArrayList<CaesarCipher> getSubCiphers() {
        return subCiphers;
    }

    public int getNextIndexForEncrypt() {
        return nextIndexForEncrypt;
    }

    public VigenereCipher(Iterable<Integer> shiftAmounts){
		nextIndexForEncrypt = 0;
		nextIndexForDecrypt = 0;

		subCiphers = new ArrayList<>();
		for(Integer amt : shiftAmounts){
			subCiphers.add(new CaesarCipher(amt));
		}
	}

	public VigenereCipher(VigenereCipher other){
		this.nextIndexForDecrypt = other.getNextIndexForDecrypt();
        this.nextIndexForEncrypt = other.getNextIndexForEncrypt();
        for (CaesarCipher c : other.getSubCiphers())
        {
            CaesarCipher t = new CaesarCipher(c);
            this.subCiphers.add(t);
        }
	}

@Override
	public char encrypt(char c) {
		char res = subCiphers.get(nextIndexForEncrypt).encrypt(c);
		nextIndexForEncrypt = (nextIndexForEncrypt + 1) % subCiphers.size();
		return res;
	}


	public char decrypt(char c) {
		char res = subCiphers.get(nextIndexForDecrypt).decrypt(c);
		nextIndexForDecrypt = (nextIndexForDecrypt + 1) % subCiphers.size();
		return res;
	}

	// Returns a new object, a deep copy of the current object

	public Cipher newCopy() {
        VigenereCipher giveBack = new VigenereCipher(this);
		return giveBack;
	}

}

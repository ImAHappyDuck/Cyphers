import java.util.ArrayList;
public class CompositionCipher extends Cipher{

    //Private array list of ciphers that are used to enrcypt and decrypt
    private ArrayList<Cipher> ciphers = new ArrayList<Cipher>();

    //Two constructor classes, Should be all good
    public CompositionCipher(){}
    public CompositionCipher(CompositionCipher other){}

    //@Override
    public char encrypt(char c){
        //Encryption loops forward changing that value of nextChar
        char nextChar = c;
        for(int i = 0; i < ciphers.size(); i++){
            nextChar = ciphers.get(i).encrypt(nextChar);
        }
        return nextChar;
    }
    public char decrypt(char c){
        //Decryption is the same but loops backwards
        char nextChar = c;
        for(int i = ciphers.size(); i>0; i--){
            nextChar = ciphers.get(i).decrypt(nextChar);
        }
        //stub
        return nextChar;
    }
    @Override
    public Cipher newCopy() {
        //Im not really sure if this is correct
        CompositionCipher cc = new CompositionCipher();
        return cc;
        //stub
        //return null;
    }
    public void add(Cipher theCipher){
        //need to make a deep copy of the arguments
        ciphers.add(theCipher);
    }
}

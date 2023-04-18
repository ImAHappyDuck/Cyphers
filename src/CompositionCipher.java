import java.util.ArrayList;
public class CompositionCipher extends Cipher {

    //Private array list of ciphers that are used to enrcypt and decrypt
    private ArrayList<Cipher> ciphers = new ArrayList<Cipher>();

    public ArrayList<Cipher> getCiphers() {
        return ciphers;
    }

    public void setCiphers(ArrayList<Cipher> ciphers) {
        this.ciphers = ciphers;
    }

    //Two constructor classes, Should be all good
    public CompositionCipher() {
    }

    public CompositionCipher(CompositionCipher other) {
        ArrayList<Cipher> gB = new ArrayList<>();
      for(Cipher c : other.getCiphers())
      {
          gB.add(c.newCopy());
      }
      this.ciphers = gB;
        }

        //@Override
        public char encrypt ( char c){
            //Encryption loops forward changing that value of nextChar
            char nextChar = c;
            for (int i = 0; i < ciphers.size(); i++) {
                nextChar = ciphers.get(i).encrypt(nextChar);
            }
            return nextChar;
        }
        public char decrypt ( char c){
            //Decryption is the same but loops backwards
            char nextChar = c;
            for (int i = ciphers.size()-1; i > -1; i--) {
                nextChar = ciphers.get(i).decrypt(nextChar);
            }
            //stub
            return nextChar;
        }

        public Cipher newCopy () {
            //Im not really sure if this is correct
            CompositionCipher cc = new CompositionCipher(this);
            return cc;
            //stub
            //return null;
        }
        public void add (Cipher theCipher){
            //need to make a deep copy of the arguments
            ciphers.add(theCipher);
        }
    }






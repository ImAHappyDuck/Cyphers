import java.util.Scanner;

public abstract class Cipher {

    public abstract char encrypt(char c);

    public abstract char decrypt(char c);

    public String encrypt(String s) {
        //StringBuilder sb = new StringBuilder();
        String e = "";
//        Scanner sc = new Scanner(s);
//        sc.useDelimiter("");
        for(int i = 0; i < s.length(); i++ ) {
          //
            e = e + encrypt(s.charAt(i));
        }
        return e; //sb.toString();
    }

    public String decrypt(String s) {
        StringBuilder sb = new StringBuilder();
        String e = "";
        for(int i = 0; i < s.length(); i++ ) {
            //
            e = e + decrypt(s.charAt(i));
        }
        return e;//sb.toString();
    }

    public abstract Cipher newCopy();

    public Cipher newCopy(Cipher c)//;//Should this be abstract???
    {
        return c.newCopy();
    }


}

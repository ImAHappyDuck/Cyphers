import java.util.Scanner;

public abstract class Cipher {


public abstract char encrypt (char c);

public abstract char decrypt (char c);



public String encrypt (String s)
{
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner(s);
    sc.useDelimiter("");
    while (sc.hasNext())
    {
        sb.append(encrypt(sc.next()));
    }
    return sb.toString();
}
public String decrypt (String s)
{
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner(s);
    sc.useDelimiter("");
    while (sc.hasNext())
    {
        sb.append(decrypt(sc.next()));
    }
    return sb.toString();
}
public abstract Cipher newCopy(Cipher c);//Should this be abstract???


}

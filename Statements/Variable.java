
/**
 * creation of legal Java variables
 * 
 * @author smk
 * @version 1
 */
import java.util.Random;
public class Variable
{
    // instance variables - replace the example below with your own
    private static int counter=0;
    public static String freshVar() { return "x" + (counter++); }
}

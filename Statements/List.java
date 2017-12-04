
/** immutable lists of strings, these are supposed to be variable names */
public class List
{
    public final String vname; 
    public final List next;
    List (String v,List n) { vname=v; next=n; }

    public String first() { return vname; }

    public List tail()    { return next;  }

    public String nth(int n) {
        if (n>=0) {
            for (List current=this; current!=null; current=current.next) {
                if (n==0) return current.vname;
                else { n--; }
            }
        }
        throw new IndexOutOfBoundsException("list index violation");
    }

    public static List cons (String v, List li) {
        return new List(v,li);
    }
    
    /** transforms variable list into sequence of variable declarations */
    public static String toString(List x) {
        if (x==null) return "";
        String res= "int " + x.vname;
        if (x.next==null) return res;
        return res + "," + toString(x.next);
    }

}

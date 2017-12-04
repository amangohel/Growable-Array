
/**
 * read the nth input
 * 
 * @author smk
 * @version 1
 */
public class Project extends Statement
{
    private int n;

    /**
     * Constructor for objects of class Project
     */
    public Project(int n)
    {
        this.n=n;
        assert n>=0;
    }

    public String produceStatement(List explist, String resultvar){
        assert explist!=null;
        return resultvar + "=" + explist.nth(n) + ";\n";
    }
    
    public String produceExpression(List explist) {
        assert explist!=null;
        return explist.nth(n);
    }
    
    public boolean expressionLike() { return true; }
}

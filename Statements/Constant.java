
/**
 * a constant computation
 * 
 * @author smk
 * @version 1
 */
public class Constant extends Statement
{
    private int theConstant;
    public Constant(int c)
    {
        theConstant=c;
    }

    public String produceStatement(List expList,String resultvar) {
        return resultvar + "=" + theConstant + ";\n";
    }
    
    public boolean expressionLike() { return true; }
    public String produceExpression(List expList) {
        if (theConstant<0) {
            return "("+theConstant+")";
        } else {
            return ""+theConstant;
        }
    }
}

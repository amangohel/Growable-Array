
/**
 * the += statement
 * 
 * @author smk
 * @version 1
 */
public class AddConstant extends Statement
{
    // the constant to be added to result
    private int theConstant;

    public AddConstant(int c)
    {
        theConstant=c;
    }
    
    private String addConstant() {
        if (theConstant<0) return ""+theConstant;
        else return "+" + theConstant;
    }

    public String produceStatement(List expList,String resultvar) {

        return resultvar + "=" + produceExpression(expList) + ";\n";
    }
    
    public boolean expressionLike() { return true; }
    
    public String produceExpression(List expList) {
        assert expList!=null;
        return expList.first() + addConstant();
    }
}

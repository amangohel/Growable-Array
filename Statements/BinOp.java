
/**
 * binary operator for integers
 * 
 * @Aman Gohel
 * @16/12/2016
 */
public class BinOp extends Statement
{
    protected final String op;

    public BinOp(String op)
    {
        this.op=op;
    }
    
    /**
     * Checks whether the statement is expression like
     * Returns true if it is.
     */
    public boolean expressionLike() {
        return true;
        //this should be replaced with true once 'produceExpression' is implemented
    }
    
    /**
     * Fetches the first two elements from explist
     * Sticks the binary operator 'op' in between
     * returns the resulting string
     * @param explist the list that we are producing.
     */
    public String produceExpression(List explist) {
        return explist.first() + op + explist.tail().first();
        //this should fetch the first two elements from List explist,
        //stick the binary operator 'op' in between
        //and return the resulting String
        //the first element of the list is the left operand, the second the right operand
        //if the list has less than two elements throw an Error
    }
    
    /**
     * Returns the composite statement
     * @param explist the list that we are producing
     * @param resultvar the produced result
     */
    public String produceStatement(List explist,String resultvar) {
        return resultvar + "=" + produceExpression(explist) + ";" + "\n";
        //as above, but instead of returning the composite expression
        // a op b
        //this should return the composite statement 
        //resultvar = a op b
    }


}

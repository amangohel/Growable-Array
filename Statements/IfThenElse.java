
/**
 * if then else statements
 * 
 * @Aman Gohel
 * @16/12/2016
 */
public class IfThenElse extends Statement
{
    private Statement cond, thenPart, elsePart;
    
    /**
     * Constructor for objects of class IfThenElse
     */
   public IfThenElse(Statement cond, Statement thenPart, Statement elsePart)
   {
       this.cond = cond;
       this.thenPart = thenPart;
       this.elsePart = elsePart;
   }

   public boolean expressionLike() {
       return false;
       //this should stay false, we do not translate if-then-else into expressions
    }
    
   public String produceExpression(List expList) {
       return null;
       //this should stay null, for the above reason
    }
    
    /**
     *  Using the if, then and else parts
     *  Each component of the statement is produced if it is expressionLike
     *  The result is then returned into a readable format
     *  @param expList the list that we are producing.
     *  @param resultvar the produced result.
     */
    public String produceStatement(List expList,String resultvar) {
        String p1 = cond.produceExpression(expList);
        String p2 = thenPart.produceStatement(expList, resultvar);
        String p3 = elsePart.produceStatement(expList, resultvar);
        
        return "if (" + p1 + ") " + p2 +
        "else " + p3;
    }
}

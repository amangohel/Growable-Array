
/**
 * relational operators are having the added complication that
 * we have no boolean type in the world of our integer statements
 * so false/true, needs converting to 0/1, respectively
 * 
 * @Aman Gohel
 * @16/12/2016
 */
public class RelOp extends BinOp
{
 
    public RelOp(String op)
    {
        super(op);
    }

    /**
     * Checks whether the statement is expression like
     * Uses a ternery operator
     * Returns either true or false
     * @param value
     * checks expression if it is expression like
     */
    public int expressionLike(boolean value)
    {
        return (value) ? 1 : 0;
    }
}

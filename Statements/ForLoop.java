
/**
 * for-loop, primrec style
 * both statements share their parameter list, except that the loop has two
 * additional parameters; the first is the loop-counter, the second a variable
 * that stores "the result" of the loop iterations
 * this var is initialised to the computation result of the first statement
 * 
 * @author smk
 * @version 1
 */
public class ForLoop extends Statement
{
    // instance variables - replace the example below with your own
    private Statement baseCase, loopBody;

    /**
     * Constructor for objects of class ForLoop
     */
    public ForLoop(Statement baseCase,Statement loopBody)
    {
        this.baseCase=baseCase;
        this.loopBody=loopBody;
    }

    public String produceStatement(List explist, String resultvar) {
        String indexVar=Variable.freshVar();
        String s1=baseCase.produceStatement(explist,resultvar);
        List bodyarg=List.cons(indexVar,List.cons(resultvar,explist));
        String s2=loopBody.produceStatement(bodyarg,resultvar);
        return s1 +
        "for(int "+indexVar+"=0; "+
        indexVar + "<" + explist.first() + "; "+
        indexVar + "++) {\n" +
        s2 + "}\n";
    }
}

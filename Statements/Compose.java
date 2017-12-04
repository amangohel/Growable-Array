
/**
 * Generalised composition
 * 
 * @author (smk 
 * @version 1
 */
public class Compose extends Statement
{
    // instance variables - replace the example below with your own
    private Statement[] arguments;
    private boolean anExpression;

    //the flag is computed once, at object creation time
    public boolean expressionLike() { return anExpression; }

    public Compose(Statement[] args)
    {
        arguments=args;
        if (args == null || args.length<2) {
            throw new IllegalArgumentException("to compose, we need at least two things");
        }
        anExpression=true;
        for (int i=0; i<args.length; i++) {
            if (!args[i].expressionLike()) {
                anExpression=false; break;
            }
        }
    }

    public String produceStatement(List varlist, String resultvar){
        String intermediate[]=new String[arguments.length];
        List newArg=null;
        String res="";
        for (int i=intermediate.length-1; i>0; i--) {
            if (arguments[i].expressionLike()) {
                intermediate[i]=arguments[i].produceExpression(varlist);
            } else {
                intermediate[i]=Variable.freshVar();
                res+="int " + intermediate[i] +";\n";
                res+=arguments[i].produceStatement(varlist,intermediate[i]);
            }
            newArg=List.cons(intermediate[i],newArg);
        }
        res+=arguments[0].produceStatement(newArg,resultvar);
        return res;
    }

    public String produceExpression(List varlist) {
        if (!anExpression) return null;
        String intermediate[]=new String[arguments.length];
        List newArg=null;
        String res="";
        for (int i=intermediate.length-1; i>0; i--) {
            intermediate[i]=arguments[i].produceExpression(varlist);
            newArg=List.cons(intermediate[i],newArg);
        }
        return arguments[0].produceExpression(newArg);
    }

}

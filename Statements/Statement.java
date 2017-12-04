
/**
 * abstract idea of a statement:
 * read input data from a list of variables
 * do some computation, store the result in result variable at the end
 * 
 * however, we are producing just the text for Java code that would do the job for us
 * 
 * @author smk 
 * @version 1
 */

public abstract class Statement
{

    abstract public String produceStatement(List varlist, String resultvar);
    public boolean expressionLike() {
        return false; // default value, to be overridden by subclasses
    }
    public String produceExpression(List varlist) {
        return null; // default, for non-expression-like statements
    }

    private static final String resultVar = "result";
    private static final String prefix    = "static int program() {\n";
    private static final String suffix    = "\nreturn" + resultVar + "\n}\n";

    public String program() {
       return prefix + produceStatement(null,resultVar) + suffix;
   }   

   private String methodHeader(String methodName,List varList) {
       return "static public int " + methodName + "(" + List.toString(varList) + ")";
    }
    
    public void printMethod(List varlist, String methodname) {
        String top=methodHeader(methodname,varlist);
        if (expressionLike()) {
            System.out.println( top + " {\n return " + produceExpression(varlist) + ";\n}" );
        } else {
            String resultVar=Variable.freshVar();
            String res=top+" {\nint "+ resultVar + ";\n";
            res+=produceStatement(varlist,resultVar);
            res+= "return " + resultVar + ";\n" + "}\n";
            System.out.println(res);
        }
    }

}

/**
 * Test class which creates the statements related to question 3
 * and for general testing purposes.
 * 
 * @Aman Gohel
 * @16/12/2016
 */

public class Test
{
    public static Statement Q3;
    /**
     * Test method for Question 3
     * Creates the statement
     */
    public static void printQ3() {
        Statement cond = new RelOp ("==");
        Statement thenPart = new Project(0);
        Statement elsePart = new BinOp("*");
        Statement Q3 = new IfThenElse(cond, thenPart, elsePart);
        Q3.printMethod(List.cons("x",List.cons("y",null)),"method");
    }
    
    public static void test()
    {
        Statement p1=new Project(1);
        Statement succ=new AddConstant(1);
        Statement add1to2=new Compose(new Statement[]{succ,p1});
        Statement addloop=new ForLoop(p1,add1to2);
        addloop.printMethod(List.cons("a",List.cons("b",null)),"addmethod");

    } 
    
}

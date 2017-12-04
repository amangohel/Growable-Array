
/**
 * GLArray Class
 * This class contains the Length, get and add methods of the GLArray data structure.
 * 
 * @author (Aman Gohel) 
 * @version (Version 1)
 */
public class GLArray
{
    
    /**
     *  Returns the length of the array.
     *  @param Node T Parameter object of Node
     */
    public static int Length (Node T){
        if (T.tail == null) {
            return T.size;
        } else {
            return T.size + Length(T.tail);
        }
    }

    /**
     *  If the index is out of bounds throw an exception
     *  Else return the value in the array corresponding
     *  to the given index.
     *  @param n the node.
     *  @param idx is the index within the array.
     */
    public static int get(Node n, int idx) throws ArrayIndexOutOfBoundsException {
        if (idx >= Length(n))
            throw new ArrayIndexOutOfBoundsException();
        else{
            while (true) {
                if (idx >= n.head.length) 
                {
                    idx -= n.size;
                } else 
                {
                    return n.head[idx];
                }
                n = n.tail;
            }
        }
    }

    /**
     *  Takes in a node and an integer value
     *  and adds it onto the end of the GLArray
     *  If the array is full then create another node
     *  and link it
     */
    public static void add(Node n, int p)  {
        if (n.size < n.head.length) 
        {
            n.head[n.size] = p;
            n.size ++;
        } else if (n.tail == null) {
            Node newHead = new Node (n.size*2);
            newHead.head[newHead.size] = p;
            newHead.size++;
            n.tail = newHead;
        } else
        {
            add(n.tail, p);
        }
    }

    /**
     *  Creates new node
     *  add test data to nodeTest.
     *  Print the length of the Node.
     *  Print the index position within the Node.
     *  Print the contents of the nodes.
     *  Prints an index out of bounds to test exception
     */
    public static void main (String [] args)
    {   
        Node nodeTest = new Node(1);
        add(nodeTest, 1);
        add(nodeTest, 2);
        add(nodeTest, 3);
        add(nodeTest, 4);
        add(nodeTest, 5);
        System.out.println(Length(nodeTest));
        System.out.println(get(nodeTest, 1));
        System.out.print(nodeTest.toString());
        //Checking here if the correct exception error is sent.
        System.out.println(get(nodeTest, 6));
        
    }
    // Part D efficiency
    /**
     *  A: The time the get method takes would vary depending on the number of nodes allocated within the GLArray. 
     *  In this example, I feel that the GLArray would take n/100 number of steps as it must check each node only once.
     *  
     *  B: Just like in question 1, if we increase the size of the array we increase the number of steps. 
     *  And as in this case it would take log(n) number of steps due to the fact the array is expanding and we check each node once.
     *  
     *  C: The add method in the GLArray would be Logarithmic due to the fact it needs to reach the final element in the array in order to add more elements.
     *  
     *  D: Since the GLArray is expandable, this would make it a better suited data structure for adding elements as it is more resource efficient. 
     *  On the other hand, using a regular growable array would enable you to refer to smaller data sets and indexes much faster. 
     */

}


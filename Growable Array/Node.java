import java.util.Arrays;
/**
 * Node Class for use with the GLArray
 * 
 * @author (Aman Gohel) 
 * @version (Version 1)
 */
class Node {
    Integer [] head;
    public Node tail;
    public int size;

    /**
     *  Constructor for class Node
     */
    public Node(int size) {
        this.size = 0;
        head = new Integer [size]; 
        tail= null; 
    }

    /**
     *  This method converts the data from the node into a String.
     */
    public String toString() {
        if (tail != null)
            return Arrays.deepToString(head) + tail.toString();
        else {
            return Arrays.deepToString(head);
        }
    }

    /**
     *  Returns the size 
     */
    public int getLength()
    {
        return size;
    }

}


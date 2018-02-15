package ots;
import java.util.LinkedList;
import java.util.List;
/**
*
* @author Scott
*/
public class Node{
    public Node(int val){
        value = val;
        successors = new LinkedList();
    }
    int value;
    List<Node> successors;
}

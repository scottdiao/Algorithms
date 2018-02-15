package ots;

import java.util.List;

/**
*
* @author Scott
*/
public class DAG  {
    
    
    public static void main(String[] args){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.successors.add(b);
        a.successors.add(c);
        b.successors.add(c);
        b.successors.add(d);
        c.successors.add(d);
        System.out.println(longestPath(a,d));
    }
    
    public static int longestPath(List<List<Integer>> dag, int target){
        
    }
    
    public static int longestPath(Node root, Node target){
        return helper(root, target, 0);
    }
    
    public static int helper(Node node, Node target, int cost){
        if(node==null) return 0;
        if(node==target) return cost+target.value;
        int res=0;
        for(Node n:node.successors){
            res = Math.max(res, helper(n, target, cost+node.value));
        }
        return res;
    }
}

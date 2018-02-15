package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
*
* @author Scott
*/
public class ConstructStringfromBinaryTree  {
    // recursion
      public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null) // if right child is null, we don't want to add (), but if left child is null, we need to
            // add () to indicate left child is null
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";   
    }
      
     
    //Stack  
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set < TreeNode > visited = new HashSet < > ();
        String s = "";
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s += ")";
            } else {
                visited.add(t);
                s += "(" + t.val;
                if (t.left == null && t.right != null)
                    s += "()";
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
}

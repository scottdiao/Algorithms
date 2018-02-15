package leetcode;

import java.util.Stack;

//Kinda simulate the traversal, keeping a stack of nodes (just their values) of which we're 
//still in the left subtree. If the next number is smaller than the last stack value, 
//then we're still in the left subtree of all stack nodes, 
//so just push the new one onto the stack. But before that, pop all smaller ancestor values, 
//as we must now be in their right subtrees (or even further, 
//in the right subtree of an ancestor). Also, use the popped values as a lower bound,
//since being in their right subtree means we must never come across a smaller number anymore.
public class VerifyPreorderSequenceinBinarySearchTree{
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop(); // lower bound for the level
            path.push(p);
        }
        return true;
    }
}

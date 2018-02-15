package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the postorder traversal of its nodes' values.
//
//For example:
//Given binary tree [1,null,2,3],
//
//   1
//    \
//     2
//    /
//   3
// 
//
//return [3,2,1].
//
//Note: Recursive solution is trivial, could you do it iteratively?

// 一致的方法自己硬背
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
	 LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
    
}

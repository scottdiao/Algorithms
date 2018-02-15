package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the preorder traversal of its nodes' values.
//
//For example:
//Given binary tree [1,null,2,3],
//   1
//    \
//     2
//    /
//   3
//return [1,2,3].
//
//Note: Recursive solution is trivial, could you do it iteratively?


public class BinaryTreePreorderTraversal  {
    //一致方法
    public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;   
            }
        }
        return result;
    }
    
    
    public List<Integer> preorderTraversal(TreeNode node) {
	List<Integer> list = new LinkedList<>();
	Stack<TreeNode> rights = new Stack<>();
	while(node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
	}
        return list;
    }
    // GIPlan
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode node) {
        helper(node);
        return res;
    }
    
    public void helper(TreeNode node){
        if(node == null) return ;
        res.add(node.val);
        helper(node.left);
        helper(node.right);
    }
    
    public List<Integer> preorderTraversal(TreeNode node) {
	List<Integer> list = new LinkedList<Integer>();
        if(node==null) return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return list;
    }
}

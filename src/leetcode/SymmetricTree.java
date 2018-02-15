package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following [1,2,2,null,3,null,3] is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//Note:
//Bonus points if you could solve it both recursively and iteratively.


public class SymmetricTree  {
    
//    recursive
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val)
            && isMirror(left.right, right.left)
            && isMirror(left.left, right.right);
    }
    
//    iterative
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
    
// GIPlan
    
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if(left==null||right==null) return left==right;
        if(left.val!=right.val) return false;
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }
}

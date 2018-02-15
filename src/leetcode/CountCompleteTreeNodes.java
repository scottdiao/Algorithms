package leetcode;
/**
*
* @author Scott
*/
//Given a complete binary tree, count the number of nodes.
//
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled,
//and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth)
            // 2 的 leftDepth 次方
            return (1 << leftDepth) - 1;
        else
            return 1+countNodes(root.left) + countNodes(root.right);

    }
    
    //不是树高而是最左边长
    private int rightDepth(TreeNode root) {
        return root==null?0:1+rightDepth(root.right);
    }
    
    //不是树高而是最右边长
    private int leftDepth(TreeNode root) {
        return root==null?0:1+leftDepth(root.left);
    }
    
}

package leetcode;

//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if(l==0||r==0)
            return l+r+1;
        else
            return Math.min(l,r)+1;
    }
}

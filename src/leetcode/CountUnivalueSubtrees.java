package leetcode;
/**
*
* @author Scott
*/
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5
 

return 4.

 

这道题让我们求相同值子树的个数，就是所有节点值都相同的子树的个数，之前有道求最大BST子树的题Largest BST Subtree，感觉挺像的，都是关于子树的问题，解题思路也可以参考一下，我们可以用递归来做，第一种解法的思路是先序遍历树的所有的节点，然后对每一个节点调用判断以当前节点为根的字数的所有节点是否相同，判断方法可以参考之前那题Same Tree，用的是分治法的思想，分别对左右字数分别调用递归，参见代码如下：
public class CountUnivalueSubtrees  {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }
    
    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}

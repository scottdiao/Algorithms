package leetcode;
/**
*
* @author Scott
*/
public class SumofLeftLeaves  {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(root.left!=null){
            if(root.left.left==null&&root.left.right==null){
                sum+=root.left.val;
            }
        }
        if(root.left!=null)sumOfLeftLeaves(root.left);
        if(root.right!=null)sumOfLeftLeaves(root.right);
        return sum;
    }
    
}

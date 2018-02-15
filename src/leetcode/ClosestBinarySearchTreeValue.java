package leetcode;
/**
*
* @author Scott
*/
public class ClosestBinarySearchTreeValue  {
    //在微软的OTS之中，我用了res和diff,多用了一个变量，其实只用res就行，还有这种单向遍历，其实应该用遍历节省空间
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;   
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }      
            root = root.val > target? root.left: root.right;
        }     
        return ret;
    }

    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}

package leetcode;
/**
*
* @author Scott
*/

//dfs all the nodes of the tree, each node return two number, int[] num,
//num[0] is the max value while rob this node, num[1] is max value while not rob this value. Current node return value only depend on its children's value. Transform function should be very easy to understand.

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    private int[] dfs(TreeNode x) {
        if (x == null) return new int[2];
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + x.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
    
    //GIPlan
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    
    public int[] dfs(TreeNode node) {
        int[] res = new int[2];
        if(node==null) return res;
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        res[0] = Math.max(left[0], left[1])+Math.max(right[0], right[1]);
        res[1] = left[0]+right[0]+node.val;
        return res;
    }
}

package leetcode;

import java.util.HashMap;

/**
*
* @author Scott
*/
public class PathSumIII {
    // 这是一道经典的动规求线段和
     public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return dfs(root, 0, sum, preSum);
    }
    
    public int dfs(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        // using HashMap to store ( key : the prefix sum, value : how many ways get to this prefix sum)
        // only currSum = target will return 1 at the first time
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += dfs(root.left, currSum, target, preSum) + dfs(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1); // that is the spirit of backtracking
        return res;
    }
    
    
    
    
    // pure dfs
     public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int findPath(TreeNode root, int sum){
        int res = 0;
        if(root == null)
            return res;
        if(sum == root.val)
            res++;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
}

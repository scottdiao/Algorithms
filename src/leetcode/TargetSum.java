package leetcode;
/**
*
* @author Scott
*/
public class TargetSum {
//    2 * sum(P) = target + sum(nums)
//  0 1 knapsack
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < target || (target + sum) % 2 > 0 ? 0 : subsetSum(nums, (target + sum) >>> 1); 
    }   

    public int subsetSum(int[] nums, int target) {
// dp[i] means how many ways to add up to target 'target'
        int[] dp = new int[target + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = target; i >= n; i--)
                dp[i] += dp[i - n]; 
//              dp[i]=dp[i]+dp[i-n]
        return dp[target];
    } 
}

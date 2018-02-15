package leetcode;

import java.util.Arrays;

/**
*
* @author Scott
*/
// 0，1 knapsack


public class PartitionEqualSubsetSum  {
    
    // first we calculate the total sum, then we find if there is a combination
    // of the array can add up to sum/2, then it will equal to the rest
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
    // if the total is odd, can not partition into two equal number
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;
//  dp[i] means if there is a combination of the array can add up to i
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }
//  dp[i][j] means whether the specific sum j can be gotten from the first i numbers
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                // if the previous i-1 items already make it up to j, it will be true
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }
}

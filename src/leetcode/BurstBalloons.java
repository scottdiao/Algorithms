package leetcode;
/**
*
* @author Scott
*/
public class BurstBalloons  {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
//        set the nums[] just add the first and last boundary
        nums[0] = nums[n++] = 1;

//        dp[i][j] stores the max coin between index i and j
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
    // left .........i..........right    after adding dp[left][i] and dp[i][right]
    // it becomes left i right, we just need to add nums[left] * nums[i] * nums[right]
                    dp[left][right] = Math.max(dp[left][right], 
                    nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}

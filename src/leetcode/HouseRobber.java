package leetcode;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
//the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
//and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.


public class HouseRobber  {
    
//  dp[i][1] means we rob the current house and dp[i][0] means we don't,
//
//  so it is easy to convert this to O(1) space
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
    
    
    public int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            //如果我们不抢n， 更新prevNo
            prevNo = Math.max(prevNo, prevYes);
            //如果我们抢n， 更新prevYes
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}

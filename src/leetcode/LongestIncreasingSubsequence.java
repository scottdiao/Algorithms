package leetcode;

import java.util.Arrays;

/**
*
* @author Scott
*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
//     dp[i] stores the LIS upto index i
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    
    
    
    ///????
    //So dp[i] is the minimum value a subsequence of length i+1 might end with
//    input: [0, 8, 4, 12, 2]
//
//    dp: [0]
//
//    dp: [0, 8]
//
//    dp: [0, 4]
//
//    dp: [0, 4, 12]
//
//    dp: [0 , 2, 12]
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
    
    // GIPlan
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0]=1;
        int res = 1;
        for(int i=1;i<nums.length;i++){
            int maxVal = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal+1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

package leetcode;
/**
*
* @author Scott
*/
public class BestTimetoBuyandSellStockIV  {
//DP: dp(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).
     public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        
        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                //在J决定卖不卖，如果不卖就相当于(dp[i][j - 1]， 如果买的话就是tmpMax, 前面多买一次额最优解
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                //j决定买不买，更新多买一次的最优解
                tmpMax =  Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }
    

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}

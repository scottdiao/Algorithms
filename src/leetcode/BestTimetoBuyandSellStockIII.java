package leetcode;

//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//

public class BestTimetoBuyandSellStockIII {
    
//    he thinking is simple and is inspired by the best solution from Single Number II (I read through the discussion after I use DP).
//Assume we only have 0 money at first;
//4 Variables to maintain some interested 'ceilings' so far:
//The maximum of if we've just buy 1st stock, if we've just sold 1nd stock, if we've just buy 2nd stock, if we've just sold 2nd stock.
//Very simple code too and work well. I have to say the logic is simple than those in Single Number II.

    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
//	public int maxProfit(int[] prices) {
//        if(prices.length<2) return 0;
//        int len = prices.length;
//        int[] preProfit = new int[len];
//        int[] postProfit = new int[len];
//        int curMin = 0;
//        int curMax = 0;
//        int maxProfit = 0;
//        
//        for(int i=1;i<len;i++){
//            curMin=Math.min(curMin,prices[i]);
//            preProfit[i]=Math.max(preProfit[i-1],prices[i]-curMin);
//        }
//        
//        for(int i=len-2;i>=0;i--){
//            curMax=Math.max(curMax,prices[i]);
//            postProfit[i]=Math.max(postProfit[i+1],curMax-prices[i]);
//        }
//        
//        for(int i=1;i<len;i++){
//            maxProfit = Math.max(maxProfit,preProfit[i]+postProfit[i]);
//        }
//        return maxProfit;
//    }
}

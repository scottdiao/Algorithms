package leetcode;

//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most k transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//Example 1:
//Input: [7, 1, 5, 3, 6, 4]
//Output: 5
//
//max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
//Example 2:
//Input: [7, 6, 4, 3, 1]
//Output: 0
//
//In this case, no transaction is done, i.e. max profit = 0.


public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
       if(prices.length<2){
           return 0;
       }
       int curmin = prices[0];
       int maxProfit = 0;
       for(int i=1;i<prices.length;i++){
           curmin = Math.min(curmin,prices[i]);
           maxProfit = Math.max(maxProfit,prices[i]-curmin);
       }
       return maxProfit;
    }
    
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int release = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release = Math.max(release, hold+i);     // The maximum if we've just sold 1nd stock so far.
            hold    = Math.max(hold,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release; ///Si
    }

}

package leetcode;



//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//For example, given the following matrix:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//Return 4.


public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
          return 0;

        int max = 0, m = matrix.length, n = matrix[0].length;

        // dp(i, j) represents the length of the square 
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        int[][] dp = new int[m + 1][n + 1];
        
        // 0 1 1 1
        // 1 1 1 1
        // 1 1 1 1
        // 1 1 1 1
        //Return 9.
        // 对于最后一个1， dp[i - 1][j - 1]=2， dp[i - 1][j], dp[i][j - 1=3， 取最小的2
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    //选取三个正方形最小的一边
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        // return the area
        return max * max;
    }
}

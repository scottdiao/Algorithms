package leetcode;
/**
*
* @author Scott
*/
public class LongestLineofConsecutiveOneinMatrix  {
    // 3D DP
    public int longestLine(int[][] M) {
        if (M.length == 0)
            return 0;
        int ones = 0;
        int[][][] dp = new int[M.length][M[0].length][4];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
 // Here, dp[0]dp[0], dp[1]dp[1], dp[2]dp[2] ,dp[3]dp[3] are used to store the maximum number of continuous 1's found so far along the Horizontal, Vertical, Diagonal and Anti-diagonal lines respectively.
                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
                    dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
                    dp[i][j][3] = (i > 0 && j < M[0].length - 1) ? dp[i - 1][j + 1][3]+1 : 1;
                    ones = Math.max(ones, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        return ones;
    }
    
    //2D DP
     public int longestLine(int[][] M) {
        if (M.length == 0)
            return 0;
        int ones = 0;
        // Only need to stores the prev row
        int[][] dp = new int[M[0].length][4];
        for (int i = 0; i < M.length; i++) {
            int old = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    dp[j][0] = j > 0 ? dp[j - 1][0] + 1 : 1; // horizon line
                    dp[j][1] = i > 0 ? dp[j][1] + 1 : 1; // vertical line
                    int prev = dp[j][2]; //we need to store dp[j][2] before it changed
                    dp[j][2] = (i > 0 && j > 0) ? old + 1 : 1;  // Diagonal line
                    old = prev; // 
                    dp[j][3] = (i > 0 && j < M[0].length - 1) ? dp[j + 1][3] + 1 : 1;
                    ones = Math.max(ones, Math.max(Math.max(dp[j][0], dp[j][1]), Math.max(dp[j][2], dp[j][3])));
                } else {
                    old = dp[j][2];
                    dp[j][0] = dp[j][1] = dp[j][2] = dp[j][3] = 0; // 斷開鎖鏈 斷開魂姐
                }
            }
        }
        return ones;
    }
}

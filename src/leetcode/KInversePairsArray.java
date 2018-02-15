package leetcode;
/**
*
* @author Scott
*/
public class KInversePairsArray {
    // 1D
     public int kInversePairs(int n, int k) {
        int[] dp = new int[k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            int[] temp = new int[k + 1];
            temp[0] = 1;
            for (int j = 1; j <= k ; j++) {
                int val = (dp[j] + M - ((j - i) >= 0 ? dp[j - i] : 0)) % M;
                temp[j] = (temp[j - 1] + val) % M;
            }
            dp = temp;
        }
        return ((dp[k] + M - (k > 0 ? dp[k - 1] : 0)) % M);
    }
     
     // 2d
      public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    // i is the array index, j is the inversion pair number
                    //dp[i - 1][j] + M restore the number, if pair >= i
//                  dp[5][4] = dp[4][0] + dp[4][1] + dp[4][2] + dp[4][3] + dp[4][4]
//                  dp[5][4] = dp[5][3] + dp[4][4] 
//                  dp[3][4] = dp[3][0] + dp[3][1] + dp[3][2]
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        return ((dp[n][k] + M - (k > 0 ? dp[n][k - 1] : 0)) % M);
    }
}

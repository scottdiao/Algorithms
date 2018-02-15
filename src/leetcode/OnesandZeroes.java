package leetcode;
/**
*
* @author Scott
*/
//  0-1 backpack problem
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
//dp[i][j] stands for max number of str can we pick from strs with limitation of i "0"s and j "1"s
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int[] count = count(s);
            for (int i=m;i>=count[0];i--) 
                for (int j=n;j>=count[1];j--) 
                    dp[i][j] = Math.max(1 + dp[i-count[0]][j-count[1]], dp[i][j]);
        }
        return dp[m][n];
    }

    public int[] count(String str) {
        int[] res = new int[2];
        for (int i=0;i<str.length();i++)
            res[str.charAt(i) - '0']++;
        return res;
    }
}

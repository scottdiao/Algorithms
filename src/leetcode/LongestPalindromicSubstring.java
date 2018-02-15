package leetcode;
import java.io.Serializable;
/**
*
* @author Scott
*/
public class LongestPalindromicSubstring  {
    
    private static int lo, maxLen;
    public static void main(String[] args) {
            String a = "aba";
            System.out.println(longestPalindrome(a));
    }
    
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
        }
        if (maxLen < k - j - 1) {
            System.out.println("j:"+j);
            System.out.println("k:"+k);
            System.out.println("lo:"+lo);
            System.out.println("maxLen:"+maxLen);
                lo = j + 1;
                maxLen = k - j - 1;
        }
    }


    // 不能用整个字符串翻转再求LCS的思路，血的教训
    public static String LongestCommonString(String s1, String s2){
        int m = s1.length(), n = s2.length(), res=0, resi=0, resj=0;
        String resStr="";
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j]>res){
                        res = dp[i][j];
                        resStr = s1.substring(i-1-res+1,i);
                    }
                }else{
                    dp[i][j] = 0;
                }
//                System.out.println("i:"+i+"j:"+j+"value:"+dp[i][j]);
            }
        }
        return resStr;                                     
    }
    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

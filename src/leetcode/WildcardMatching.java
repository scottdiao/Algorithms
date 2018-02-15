package leetcode;
/**
*
* @author Scott
*/
public class WildcardMatching  {
    public static void main(String[] args) {
		
            isMatch("aa","*");
	}
    // 自己写的标准字符串匹配动规问题
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n=p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        int i=1;
        dp[0][0]=true;
        //非常关键的初始化，当s为Null时，如果p是***那么依然为true
        while(i<=p.length()&&p.charAt(i-1)=='*'){
            dp[0][i]=true;
            i++;
        }
        //可以完全忽略第一行和第一列，因为dp布尔矩阵默认都是false
        for(i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //记住了charAt时候要-1
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?') dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*') dp[i][j] = dp[i-1][j]||dp[i][j-1];
                else dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
     public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[0][0]=true;
        
//        initilize dp matrix  
//        abc
//        ***abc
        int i =0;
        while(i<p.length()&&p.charAt(i)=='*'){
            match[0][++i]=true;
        }
        
//       abccccd           ab    
//       ab*d              ab*    
        for(i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                    match[i+1][j+1]=match[i][j];
                else if(p.charAt(j)=='*')
                    match[i+1][j+1]=match[i][j+1]||match[i+1][j];
                else
                    match[i][j]=false;
            }
        }
        return match[s.length()][p.length()];
    }
     
     // GIPlan
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        int i =0;
        while(i<p.length()&&p.charAt(i)=='*'){
            dp[0][++i]=true;
        } 
        for(i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j)=='*'){
                    dp[i+1][j+1] = dp[i+1][j]||dp[i][j+1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

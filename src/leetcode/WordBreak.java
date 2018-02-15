package leetcode;

import java.util.List;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
//determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//You may assume the dictionary does not contain duplicate words.
//
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code".
//
//UPDATE (2017/1/4):
//The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.



public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        
        //Second DP
        // 这题类似于切割palidrome那道
//        dp[i] means char at i so far have substring
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}

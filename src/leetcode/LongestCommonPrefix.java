package leetcode;

import java.util.Arrays;

//Write a function to find the longest common prefix string amongst an array of strings.

public class LongestCommonPrefix  {
    
    public static void main(String[] args) {
        String a="abcde", b="de";
        System.out.println(a.indexOf(b));
    }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            // indexof will return -1 if there is no pre in the String
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
    
    
//    First sort, then compare first and last string
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        
        if (strs!= null && strs.length > 0){
        
            Arrays.sort(strs);
            
            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();
            
            for (int i = 0; i < a.length; i ++){
                if (b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }
        return result.toString();
    }
}

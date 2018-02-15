package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
*
* @author Scott
*/
public class LongestPalindrome {
    public static void main (String[] args){
        System.out.println(longestPalindrome("abccccdd"));
    }
    
    public static int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }
    
    // Really stupid!!
    public static int longestPalindrome(String s) {
        int res=0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else map.put(s.charAt(i), 1);
        }
        Iterator i = map.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry temp = (Map.Entry)i.next();
            int tmp = (Integer)temp.getValue();
            if(tmp>1) res += tmp%2==0?tmp:tmp-1;
        }
        return s.length()>res?res+1:res;
    }
}

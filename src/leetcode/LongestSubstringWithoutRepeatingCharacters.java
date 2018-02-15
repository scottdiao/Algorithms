package leetcode;

import java.util.HashMap;
import java.util.Map;

public class  WithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        // map store the rightmost index of each char
        Map<Character, Integer> map = new HashMap<>();
        // i is left, j is right
        for(int i=0,j=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                // j is the rightmost valid start point
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            ans = Math.max(ans, i-j+1);
            map.put(s.charAt(i), i);
        }
        
        return ans;
    }
}

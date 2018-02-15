package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
*
* @author Scott
*/
public class LongestSubstringwithAtMostKDistinctCharacters  {
     public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256]; // extend ASCII code is 256 char
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            //  do the incress even not equals to 0
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
//  This line is tricky, first -- count[i] to 0, then do i++, out of loop
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
     
//  A more generic solution as follows, can be solution for Unicode string:
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int best = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
//      At this point there are more than k distinct char, we need to remove them until to k
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);                     
                    if (map.get(leftChar) == 0) { 
                        map.remove(leftChar);
                    }
                }
                left++;
            }
            best = Math.max(best, i - left + 1);
        }
        return best;
    } 
}




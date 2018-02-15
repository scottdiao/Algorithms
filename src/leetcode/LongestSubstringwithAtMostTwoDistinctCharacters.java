package leetcode;

import java.util.HashMap;
import java.util.Map;



//The main idea is to maintain a sliding window with 2 unique characters. 
//The key is to store the last occurrence of each character as the value in the hashmap.
//This way, whenever the size of the hashmap exceeds 2, we can traverse through the map
//to find the character with the left most index, and remove 1 character from our map.
//Since the range of characters is constrained, we should be able to find the left most 
//index in constant time.
public class LongestSubstringwithAtMostTwoDistinctCharacters  {
    // The same as k char
     public int lengthOfLongestSubstringTwoDistinct(String s) {
       Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int best = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
//      At this point there are more than k distinct char, we need to remove them until to k
            while (map.size() > 2) {
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
     
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 1) return 0;
        HashMap<Character,Integer> index = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while(hi < s.length()) {
            if(index.size() <= 2) {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int i : index.values()) {
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost+1;
            }
            maxLength = Math.max(maxLength, hi-lo);
        }
        return maxLength;
    }
}

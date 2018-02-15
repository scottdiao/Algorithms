package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
*
* @author Scott
*/
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();// Key stores the pattern char or str in words[], value is their latest index
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) // put return the previous value
                return false;
        return true;
    }
    
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, Integer> patternMap = new HashMap<>();
        HashMap<String, Integer> stringMap = new HashMap<>();
        String[] strArray = str.split(" ");
        if(pattern.length()!=strArray.length) return false;
        for(int i=0;i<pattern.length();i++){
            int patternIndex = patternMap.getOrDefault(pattern.charAt(i),-1);
            int strIndex = stringMap.getOrDefault(strArray[i],-1);
            if(patternIndex!=strIndex) return false;
            patternMap.put(pattern.charAt(i),i);
            stringMap.put(strArray[i],i);
        }
        return true;
    }
}

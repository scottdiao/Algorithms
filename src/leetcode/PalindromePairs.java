package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
*
* @author Scott
*/
public class PalindromePairs {
    private String strrev(String s)  
    {  
        StringBuilder sb = new StringBuilder(s);  
        return sb.reverse().toString();  
    }  
  
    private boolean palindrome(String s)  
    {  
        int len = s.length();  
        for (int i = 0; i < len / 2; i++)  
        {  
            if (s.charAt(i) != s.charAt(len - 1 - i))  
            {  
                return false;  
            }  
        }  
  
        return true;  
    }  
  
    public List<List<Integer>> palindromePairs(String[] words)  
    {  
        List<List<Integer>> ret = new ArrayList<List<Integer>>();  
  
        if (null == words || 0 == words.length)  
        {  
            return ret;  
        }  
  
        Map<String, Integer> hs = new HashMap<String, Integer>();  
        for (int i = 0; i < words.length; i++)  
        {  
            hs.put(words[i], i);  
        }  
  
        if (hs.containsKey(""))  
        {  
            int index = hs.get("");  
            for (int i = 0; i < words.length; i++)  
            {  
                if (palindrome(words[i]))  
                {  
                    if (i == index) continue;  
                    ret.add(Arrays.asList(i, index));  
                    ret.add(Arrays.asList(index, i));  
                }  
            }  
        }  
  
        for (int i = 0; i < words.length; i++)  
        {  
            String rev = strrev(words[i]);  
            if (hs.containsKey(rev))  
            {  
                int index = hs.get(rev);  
                if (index == i) continue;  
                ret.add(Arrays.asList(i, index));  
            }  
        }  
  
        for (int i = 0; i < words.length; i++)  
        {  
            for (int len = 1; len < words[i].length(); len++)  
            {  
//      如果字符串s1的前n个字符是对称的，即s1[0,n），并且s1[n,len)与s2是互为相反的，则(s2,s1)构成对称字符
//      s1:abbacdef   s2:fedc    s2s1:fedcabbacdef
                if (palindrome(words[i].substring(0, len)))  
                {  
                    String rev = strrev(words[i].substring(len));  
                    if (hs.containsKey(rev))  
                    {  
                        int index = hs.get(rev);  
                        if (i == index) continue;  
                        ret.add(Arrays.asList(index, i));  
                    }  
                }  
  
                if (palindrome(words[i].substring(len)))  
                {  
                    String rev = strrev(words[i].substring(0, len));  
                    if (hs.containsKey(rev))  
                    {  
                        int index = hs.get(rev);  
                        if (i == index) continue;  
                        ret.add(Arrays.asList(i, index));  
                    }  
                }  
            }  
        }  
        return ret;  
    }  
}

package leetcode;

import java.util.HashMap;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. 
//No two characters may map to the same character but a character may map to itself.
//
//For example,
//Given "egg", "add", return true.
//
//Given "foo", "bar", return false.
//
//Given "paper", "title", return true.
//
//Note:
//You may assume both s and t have the same length.


public class IsomorphicStrings  {
    public boolean isIsomorphic(String s1, String s2) {
        if(s1 == null || s1.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s1.length(); i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                if(!map.containsValue(b))
                map.put(a,b);  //及时a==b我们也要放到map去
                else return false;
            }
        }
        return true;
    }
    
    //
    public boolean isIsomorphic(String s1, String s2) {
        if(s1 == null || s1.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap();
        for(int i=0;i<s1.length();i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b)) continue;
                else return false;
            }else{
                if(!map.containsValue(b)) map.put(a, b);
                else return false;
            }
        }
        return true;
    }
}

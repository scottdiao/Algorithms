package leetcode;

import java.util.HashMap;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//For example,
//S = "ADOBECODEBANC"
//T = "ABC"
//Minimum window is "BANC".
//
//Note:
//If there is no such window in S that covers all characters in T, return the empty string "".
//
//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.



public class MinimumWindowSubstring  {
    public String minWindow(String S, String T) { 
        if(S==null || S.length()==0)  return "";  
        HashMap<Character, Integer> map = new HashMap<>();  
        for(int i=0; i<T.length();i++){  
            if(map.containsKey(T.charAt(i))){  
                map.put(T.charAt(i),map.get(T.charAt(i))+1);  
            }else{  
                map.put(T.charAt(i),1);  
            }  
        }  
        int left = 0;
        int count = 0;  
        int minLen = S.length()+1;  
        int minStart = 0;  
        for(int right=0; right<S.length();right++){  
            if(map.containsKey(S.charAt(right))){  
                map.put(S.charAt(right),map.get(S.charAt(right))-1);  
                if(map.get(S.charAt(right))>=0){  
                    count++;  
                }  
                while(count == T.length()){  
                    if(right-left+1<minLen){  
                        minLen = right-left+1;  
                        minStart = left;                      
                    }  
//  移动窗口左端的条件是当找到满足条件的串之后，一直移动窗口左端直到有字典里的字符不再在窗口里           
                    if(map.containsKey(S.charAt(left))){  
                        map.put(S.charAt(left), map.get(S.charAt(left))+1);  
                        // <0 means in S there is more char than T, if >0 we must count--
                        // and break the while loop
                        if(map.get(S.charAt(left))>0){  
                            count--;  
                        }  
                    }  
                    left++;  
                }  
            }  
        }  
        if(minLen>S.length())  return "";  
        return S.substring(minStart,minStart+minLen);
//    }
    
    public String minWindow(String s, String t) {
        int start=0,end=0,minLen=Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count=0, left=0;
        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                count++;
            }
            while(count>t.length()){
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left))>0) count--;
                }
                left++;
            }
            if(right-left<minLen){
                minLen = right-left;
                start=left;
                end=right;
            }
        }
        return s.substring(start,end);
    }
    
}

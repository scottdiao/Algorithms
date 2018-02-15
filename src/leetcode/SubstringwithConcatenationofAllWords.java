package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//You are given a string, s, and a list of words, words, that are all of the same length. 
//Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once 
//and without any intervening characters.
//
//For example, given:
//s: "barfoothefoobarman"
//words: ["foo", "bar"]
//
//You should return the indices: [0,9].
//(order does not matter).
public class SubstringwithConcatenationofAllWords  {
    //Sliding window
     public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return result;
        } 

        //Create words[] frequency map
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words){
            if(map.containsKey(w)){
                map.put(w, map.get(w)+1);
            }else{
                map.put(w, 1);
            }
        }

        int len = words[0].length();
            
            // we need to iterate in len, since at first j=0, so the possible result
            // will be 0, len, 2len, 3len, then j=1, will be 1,len+1,2len+1
        for(int j=0; j<len; j++){
            HashMap<String, Integer> currentMap = new HashMap<>();
            int start = j;//start index of start
            int count = 0;//count totoal qualified words so far

            
            for(int i=j; i<=s.length()-len; i=i+len){
                String sub = s.substring(i, i+len);
                if(map.containsKey(sub)){
                    //set frequency in current map
                    if(currentMap.containsKey(sub)){
                        currentMap.put(sub, currentMap.get(sub)+1);
                    }else{
                        currentMap.put(sub, 1);
                    }

                    count++;
                    
                    // 如果sub出现的次数多了，我们需要右移start指针len位
                    while(currentMap.get(sub)>map.get(sub)){
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);

                        count--;
                        start = start + len;
                    }


                    if(count==words.length){
                        result.add(start); //add to result

                        //shift right and reset currentMap, count & start point         
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                }else{
                    currentMap.clear();
                    start = i+len;
                    count = 0;
                }
            }
        }

        return result;
    }

     // This is very naive
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;
        int len = words[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<>(); // map for words
        for (String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) { // checkc if match
                String str = s.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in words
            }
        }
        return res;
    }
}

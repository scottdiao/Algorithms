package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
*
* @author Scott
*/
public class AlienDictionary  {
    //topological
    public String alienOrder(String[] words) {
        // The map store the set of char which before the key char
        Map<Character, Set<Character>> map=new HashMap<>();
        // Degree store how many node connected to the current node, in other word how many char before the char
        Map<Character, Integer> degree=new HashMap<>();
        String result="";
        if(words==null || words.length==0) return result;
        // ini the degree map
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        // we need to construct a DAG, we iterate each word, and compare it to the next word,
        // for each char find the first diff char and add it to the map DAG
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        // topological sort
        Queue<Character> q=new LinkedList<>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
}

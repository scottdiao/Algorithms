package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
*
* @author Scott
*/
public class SequenceReconstruction  {
     public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>(); 
        int[] degree = new int[org.length];

        // for(int i = 1; i<=org.length; i++) map.put(i, new HashSet<>()); 
       //cannot init map with org, has to do with seqs, to avoid case like [1], [], expected: false
        
       // Construct graph
        for(List<Integer> list: seqs){
            if(list.size()==1) map.computeIfAbsent(list.get(0), k->new HashSet<>()); //dont forget
            for(int i = 1; i<list.size(); i++){
                int pre = list.get(i-1);
                int cur = list.get(i);
                map.computeIfAbsent(pre, k->new HashSet<>()); 
                map.computeIfAbsent(cur, k->new HashSet<>()); 
                if(pre>org.length || cur>org.length || pre<1 || cur<1) return false; 
                //dont forget. or degree array can "ArrayIndexOutOfBoundsException"
                
                if(!map.get(pre).contains(cur)){
                    degree[cur-1]++; 
                    map.get(pre).add(cur);
                }
            }
        }
//        BFS topological sort
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<degree.length; i++){
            if(degree[i]==0) q.add(i+1);
        }
        int index = 0;
        while(!q.isEmpty()){
            // this is the key line, for each level travelsal, check there is only one node int the level
            if(q.size()>1) return false; //check with org  if there are multiple node to start with, there is no unique
            int cur = q.poll(); 
            if(org[index++] != cur) return false; //check with org
            if(!map.containsKey(cur)) continue; //don't forget
            for(int i: map.get(cur)){
                degree[i-1]--; 
                if(degree[i-1]==0) q.add(i); 
            }
        }
        return index == org.length && index==map.size();//has to check with map size
    }
}

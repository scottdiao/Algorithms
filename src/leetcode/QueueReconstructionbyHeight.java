package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
*
* @author Scott
*/
public class QueueReconstructionbyHeight  {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        // [7,0], [4,4], [7,1], [5,0], [6,1], [5,2]
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // [7,0], [6,1], [7,1], [5,0], [5,2], [4,4]
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
    }
}

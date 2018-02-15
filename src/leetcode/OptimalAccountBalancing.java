package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
*
* @author Scott
*/
public class OptimalAccountBalancing  {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Long> map = new HashMap();
        for(int[] t: transactions){
          long val1 = map.getOrDefault(t[0], 0L);
          long val2 = map.getOrDefault(t[1], 0L);
          map.put(t[0], val1 - t[2]);
          map.put(t[1], val2 + t[2]);
        }        

        List<Long> list = new ArrayList();
        for(long val: map.values()){
          if(val != 0) list.add(val);
        }

        Long[] debts = new Long[list.size()];
        debts = list.toArray(debts);
        return helper(debts, 0 , 0);
    }

    // DFS iterate all possible solutions
    int helper(Long[] debts, int pos, int count){
        while(pos < debts.length && debts[pos] == 0) pos++;
        int res = Integer.MAX_VALUE;
        long pre = 0;
        for(int i = pos + 1; i < debts.length; i++){
          if(debts[i] != pre && debts[pos] * debts[i] < 0){
            debts[i] += debts[pos];
            res = Math.min(res, helper(debts, pos + 1, count + 1));
            debts[i] = debts[i] - debts[pos];
            pre = debts[i];
          }
        }
        return res == Integer.MAX_VALUE ? count : res;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(cand, 0, target, path, res);
        return res;
    }
    void dfs(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
            path.add(cand[i]);
            dfs(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);
        }
    }
    
    // base on combination sum 1
    List<List<Integer>> ans = new ArrayList<List<Integer>>();  
    int[] cans = {};  
      
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {  
        cans = candidates;  
        Arrays.sort(cans);  
        backTracking(new ArrayList(), 0, target);  
        return ans;  
    }  
      
    public void backTracking(List<Integer> cur, int start, int target) {  
        if (target == 0) {  
            List<Integer> list = new ArrayList<Integer>(cur);  
            ans.add(list);  
        } else {  
            
            for (int i = start; i < cans.length && cans[i] <= target; i++) {  
                if (i > start && cans[i] == cans[i-1]) continue;
                cur.add(cans[i]);  

                backTracking(cur, i+1, target - cans[i]);  
                cur.remove(new Integer(cans[i]));  
            }  
        }  
    }  
}

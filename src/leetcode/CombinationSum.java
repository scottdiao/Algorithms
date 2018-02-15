package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [2, 3, 6, 7] and target 7, 
//A solution set is: 
//[
//  [7],
//  [2, 2, 3]
//]

// Backtracking   DFS
public class CombinationSum  {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();  
    int[] cans = {};  
      
    public List<List<Integer>> combinationSum(int[] candidates, int target) {  
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
                cur.add(cans[i]);  
//                当加入cans[i]后，下一次还是从i开始，因为一个数可以用多次
                backTracking(cur, i, target - cans[i]);  
                cur.remove(new Integer(cans[i]));  
            }  
        }  
    }  
}

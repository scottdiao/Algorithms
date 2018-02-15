package leetcode;

import java.util.ArrayList;
import java.util.List;

//Find all possible combinations of k numbers that add up to a number n, 
//given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//
//Example 1:
//
//Input: k = 3, n = 7
//
//Output:
//
//[[1,2,4]]
//
//Example 2:
//
//Input: k = 3, n = 9
//
//Output:
//
//[[1,2,6], [1,3,5], [2,3,4]]
public class CombinationSumIII  {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int k,  int start, int n) {
        if (path.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(path);
            res.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(res, path, k, i+1, n-i);
            path.remove(path.size() - 1);
        }
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    
//    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//Note: The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
    
	public static void main(String[] args) {
		int[] a = {1,2,2,2};
//[]
//[1]
//[1, 2]
//[1, 2, 2]
//[1, 2, 2, 2]
//[2]
//[2, 2]
//[2, 2, 2]
                subsetsWithDup(a);
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(res, path, 0, nums);
            return res;
        }
//          [1,2,2]  []-[1]-[1,2]-[1,2,2]-[2]-[2,2]
        public static void dfs(List<List<Integer>> res, List<Integer> path, int pos, int[] n) {
            if (pos <= n.length) {
                res.add(path);
                System.out.println(path);
            }
            int i = pos;
            while (i < n.length) {
                path.add(n[i]);
                dfs(res, new ArrayList<>(path), i + 1, n);
                path.remove(path.size() - 1);
                i++;
                while (i < n.length && n[i] == n[i - 1]) {i++;}
            }
        }

}

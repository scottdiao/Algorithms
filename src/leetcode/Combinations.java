package leetcode;

import java.util.ArrayList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]


public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4,2).toString());

    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(res, path, 1, n, k);
        return res;
    }
    public static void dfs(List<List<Integer>> res, List<Integer> path, int start, int n, int k) {
        if(k==0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=start;i<=n;i++) {
            path.add(i);
            dfs(res, path, i+1, n, k-1);
            path.remove(path.size()-1);
        }
    }

}

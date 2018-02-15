package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
            int[] a = {1,2,3};
            System.out.println(permute(a));
    }
	
	
	
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        List<Integer> path = new ArrayList();
        if(nums == null || nums.length == 0) return res;
        backTracking(res, path, nums);
        return res;
    
    }
    
    static void backTracking(List<List<Integer>> res, List<Integer> path, int[] ns){
        if(ns.length == path.size()){
            res.add(new ArrayList<>(path));
            return ;
        }
    
        for(int n: ns){
            if(!path.contains(n)){
                path.add(n);
                backTracking(res, path, ns );
                path.remove(path.size() -1);
            }
        }
    }

}

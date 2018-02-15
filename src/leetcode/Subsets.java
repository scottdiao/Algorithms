package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
            int[] a = {4,1,0};
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
//    {1,2,3} -[]-[1]-[1,2]-[1,2,3]-[1,3]-[1,3,2] 

    private void backtrack(List<List<Integer>> list , List<Integer> path, int [] nums, int start){
        list.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(list, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
//    Top-down
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private List<List<Integer>> helper(List<List<Integer>> res , int [] nums, int index){
        res = helper(res,nums,index-1);
        for(int i = 0; i < res.size(); i++){
            res.add(i,nums[index]);
        }
        return res;
    }

}

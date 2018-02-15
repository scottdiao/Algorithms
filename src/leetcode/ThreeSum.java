package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
//Find all unique triplets in the array which gives the sum of zero.

/**
*
* The key is how to avoid duplicate output, if you use a List.contain, TLE, 
* so just make sure each time you iterate i,l,h, wipe out duplicate
*/
public class ThreeSum  {
    public static void main(String[] args) {
        int[] s = {-1, 0, 1, 2, -1, -4};
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int k=0;
        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                int l=i+1, h=nums.length-1;
                while(l<h){
                k=nums[i]+nums[l]+nums[h];
                if(k==0){
                    result.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (l < h && nums[l] == nums[l+1]) l++;
                    while (l < h && nums[h] == nums[h-1]) h--;
                    l++;h--;
                }else if(k>0){
                    h--;
                }else{
                    l++;
                }
            }
            }
        }
        return result;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
//Return the sum of the three integers. You may assume that each input would have exactly one solution.

/**
*
* The key is how to avoid duplicate output, if you use a List.contain, TLE, 
* so just make sure each time you iterate i,l,h, wipe out duplicate
*/
public class ThreeSumCloest  {
    public static void main(String[] args) {
        int[] s = {0,0,0};
        System.out.println(threeSumClosest(s,1));
    }
    
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int k=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                int l=i+1, h=nums.length-1;
                while(l<h){
                k=Math.min(k, Math.abs(target)-Math.abs(nums[i]-nums[l]-nums[h]));
                if(k==0){
                    System.out.println("=0");
                    return target;
                }else if(k>0){
                    h--;
                }else{
                    l++;
                }
            }
            }
        }
        System.out.println(k);
        return Math.abs(target)-k;
    }
}

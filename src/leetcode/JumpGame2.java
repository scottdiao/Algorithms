package leetcode;

import java.util.Arrays;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//For example:
//Given array A = [2,3,1,1,4]
//
//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
//
//Note:
//You can assume that you can always reach the last index.
//

public class JumpGame2  {
    public int jump(int nums[]) {
        int step = 0,curMax = 0,curRch = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > curRch){
                step ++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, nums[i]+i);
        }
        return step;
    }
    
    //GIPlan
    public int jump(int nums[]) {
        int step=0, curReach=0, max=0;
        for(int i=0;i<nums.length;i++){
            if(i>curReach){
                step++;
                curReach = max;
            }
            max = Math.max(max, i+nums[i]);
        }
        return step;
    }
}

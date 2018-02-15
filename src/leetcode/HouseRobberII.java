package leetcode;

//After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not
//get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the 
//neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous 
//street.
//
//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.


public class HouseRobberII  {
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    public int rob(int[] num, int l, int h) {
        int prevNo = 0;
        int prevYes = 0;
        for (int j=l;j<=h;j++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num[j] + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}

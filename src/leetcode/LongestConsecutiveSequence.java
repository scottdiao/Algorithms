package leetcode;

import java.util.HashSet;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity.


//这是一个Union Find 的问题， 所有连续的都可以看做一个整体
public class LongestConsecutiveSequence  {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down-1)) {
                set.remove(down);//remember to remove
                down--;
            }
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);//remember to remove
                up++;
            }
            max = Math.max(max, up - down - 1);//should be -1
        }
        return max;
    }
    
    // GIPLan
    //这是一个Union Find 的问题， 所有连续的都可以看做一个整体， 所以把除了当前数都从set中删除，这个比较清楚
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int max = 0;
        for(int i:nums){
            set.add(i);
        }
        for(int i=0;i<nums.length;i++){
            int down = nums[i]-1;
            int up = nums[i]+1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            max = Math.max(max, up-down-1);
        }
        return max;
    }
}

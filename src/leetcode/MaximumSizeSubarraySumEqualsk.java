package leetcode;

import java.util.HashMap;

//The HashMap stores the sum of all elements before index i as key, and i as value.
//For each i, check not only the current sum but also (currentSum - previousSum)
//to see if there is any that equals k, and update max length.


public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i); //Only put leftmost index
        }
        return max;
    }
      
}

package leetcode;

//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.

public class MinimumSizeSubarraySum {
//    slide window
//    Since the given array contains only positive integers, the subarray sum can only increase by including more elements.
//    Therefore, you don't have to include more elements once the current subarray already has a sum large enough.
//    This gives the linear time complexity solution by maintaining a minimum window with a two indices.
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
          return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
          sum += a[j++];

          while (sum >= s) {
            min = Math.min(min, j - i);
            sum -= a[i++];
          }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    
    private int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
           int mid = (lo + hi) / 2;
           if (sums[mid] >= key){
               hi = mid - 1;
           } else {
               lo = mid + 1;
           }
        }
        return lo;
    }
}

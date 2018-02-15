package leetcode;

import java.util.Arrays;

/**
*
* @author Scott
*/
public class ThreeSumSmaller {
    int count;
// [-2, 0, 1, 3]  target = 2
//    [-2, 0, 1]
//    [-2, 0, 3]
    public int threeSumSmaller(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
//              any number in the (left,right) can be the right that make the sum < target
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}

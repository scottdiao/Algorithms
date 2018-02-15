package leetcode;


//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//You may assume no duplicate exists in the array.

// 4 5 6 7 0 1 2            6 7 1 2 3 4 5
public class FindMinimuminRotatedSortedArray {
    
    
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid = (l + r) / 2;
            // 因为最小值是在右边线段的起始
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
//    public int findMin(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        
//        if (nums.length == 1)  return nums[0];
//        
//        int start = 0, end = nums.length - 1;
//        while (start < end) {
//            int mid = (start + end) / 2;
//// 4 5 6 7 0 1 2            6 7 1 2 3 4 5
//            if (mid > 0 && nums[mid] < nums[mid - 1]) {
//                return nums[mid];
//            }
//            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return nums[start];
//    }
}

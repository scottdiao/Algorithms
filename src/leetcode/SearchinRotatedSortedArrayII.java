package leetcode;


//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Write a function to determine if a given target is in the array.
//
//The array may contain duplicates.

public class SearchinRotatedSortedArrayII  {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            //中点在右端，因为有duplicate
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] ) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        
        return false;
    }
}

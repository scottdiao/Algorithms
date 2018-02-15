package leetcode;

//Rotate an array of n elements to the right by k steps.
//
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//Note:
//Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//
//[show hint]
//
//Related problem: Reverse Words in a String II


public class RotateArray  {
//    For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7]
    
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); // 7 6 5 4 3 2 1 
        reverse(nums, 0, k - 1);           // 5 6 7 4 3 2 1
        reverse(nums, k, nums.length - 1); // 5 6 7 1 2 3 4
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
//    Brute Force
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    
//   GIPlan
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0,  nums.length-1);
        reverse(nums, 0,  k-1);
        reverse(nums, k,  nums.length-1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

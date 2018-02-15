package leetcode;

import java.util.Random;

//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
//not the kth distinct element.
//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.
//
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length.

//基本思路快排， 二分
public class KthLargestElementinanArray  {
    public static void main(String[] args) {
        int[] a = {5,2,3,1,9,2,3,4,15,2,34,19};
        partition(a,0,a.length-1);
    }
    
    private static void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
    public static int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            // j是当前数快排后的排名，与k比较做二分
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    public static int partition(int[] num, int p, int r){
        int x = num[r];
        int i=p;
        for(int j=p;j<r;j++){
            if(num[j]<=x){
                swap(num,  i,  j);
                i++;
            }
        }
        swap(num,  i,  r);
        return i;
    }
    

    private static void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}

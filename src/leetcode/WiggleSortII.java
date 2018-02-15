package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
*
* @author Scott
*/
public class WiggleSortII  {
     public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    // find kth largest
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

    private static int partition(int[] a, int lo, int hi) {
// like quick sort, move all elements less than a[low] to the left, elements greater than a[low] move to right
// return what th largest is a[lo] in this array; 
        int i = lo;
        int j = hi + 1;
        while(true) {
//           i,j point to the element which violate the pivot condition
            while(i < hi && a[++i]<a[lo]) System.out.println("i:"+i);
//      j will continute decrese until find a element less than a[low]
            while(j > lo && a[--j]>a[lo]) System.out.println("j:"+j);
//      if i>=j, j is the right place to store the a[lo]
            if(i >= j) {
                break;
            }
            System.out.println("swap i:"+i+"  j:"+j);
            swap(a, i, j);
        }
        System.out.println("lo:"+lo);
        System.out.println("j:"+j);
        swap(a, lo, j);
        return j;
    }
    

    private static void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}

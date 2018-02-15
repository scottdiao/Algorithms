package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*
* @author Scott
*/
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

//Boyer-Moore Majority Vote algorithm

public class MajorityElementII {
    public static void main(String[] args){
        majorityElement(new int[]{1,2,3,4,3,5,6,5,7});
    }
    
    public static List<Integer> majorityElement(int[] nums) {  
        if (nums == null || nums.length == 0)
            return new ArrayList<Integer>();
	List<Integer> result = new ArrayList<Integer>();
	int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
//	since the result at most at 2, first we pick up the two candidate, but this also include the last elements
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
	}
        System.out.println(number1);
        System.out.println(number2);
//       then we see if those candidates meet the qualify
	count1 = 0;
	count2 = 0;
	for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
	}
	if (count1 > len / 3)
            result.add(number1);
	if (count2 > len / 3)
            result.add(number2);
	return result;
    }  
    
//     n/k
//    public List<Integer> majorityElement(int[] nums) {
//        int n = nums.length, k = 3;  //in this question, k=3 specifically
//        List<Integer> result = new ArrayList<Integer>();
//        if (n==0 || k<2) return result;
//        int[] candidates = new int[k-1];
//        int[] counts = new int[k-1];
//        for (int num: nums) {
//            boolean settled = false;
//            for (int i=0; i<k-1; i++) {
//                if (candidates[i]==num) {
//                    counts[i]++;
//                    settled = true;
//                    break;
//                } 
//            }
//            if (settled) continue;
//            for (int i=0; i<k-1; i++) {
//                if (counts[i]==0) {
//                    counts[i] = 1;
//                    candidates[i] = num;
//                    settled = true;
//                    break;
//                } 
//            }
//            if (settled) continue;
//            for (int i=0; i<k-1; i++) counts[i] = (counts[i] > 0) ? (counts[i]-1) : 0;
//        }
//        Arrays.fill(counts, 0);
//        for (int num: nums) {
//            for (int i=0;i<k-1; i++) {
//                if (candidates[i]==num) {
//                    counts[i]++;
//                    break;
//                }
//            }
//        }
//        for (int i=0; i<k-1; i++) if (counts[i]>n/k) result.add(candidates[i]);
//        return result;
//    }
}

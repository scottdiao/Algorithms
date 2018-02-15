package leetcode;

import java.util.Random;

//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.



public class RemoveDuplicatesfromSortedArrayII {
    
    public static void main(String[] args){
        Random random = new Random();
        System.out.println(random.nextInt(2));
    }
//    1 2 3 2 3 3
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
//            just compare to the i-2
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}

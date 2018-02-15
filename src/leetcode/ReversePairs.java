package leetcode;

import java.util.Arrays;

/**
*
* @author Scott
*/
public class ReversePairs  {
// Merge sort
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }
    
    
    
// BST  not acceptable for sorted input, it is unblanced
    class Node {
        int val, cnt;
//cnt is the total number of elements in the subtree rooted at current node that are greater than or equal to val
        Node left, right;

        Node(int val) {
            this.val = val;
            this.cnt = 1;
        }
    }
    private int search(Node root, long val) {
        if (root == null) {
            return 0;
        } else if (val == root.val) {
            return root.cnt;
        } else if (val < root.val) {
            return root.cnt + search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    private Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        } else if (val == root.val) {
            root.cnt++;
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.cnt++;
            root.right = insert(root.right, val);
        }

        return root;
    }
    
    public int reversePairs(int[] nums) {
        int res = 0;
        Node root = null;

        for (int ele : nums) {
            res += search(root, 2L * ele + 1);
            root = insert(root, ele);
        }

        return res;
    }
}

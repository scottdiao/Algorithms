package leetcode;

//Given an unsorted integer array, find the first missing positive integer.
//
//For example,
//Given [1,2,0] return 3,
//and [3,4,-1,1] return 2.
//
//Your algorithm should run in O(n) time and uses constant space.

// Only move the valid number to the correct spot

//  3 4 -1 1
// -1 4 3 1
// -1 1 3 4
//  1 -1 3 4

public class FirstMissingPositive  {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            // we see a valid or invalid a[i], ignore
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            //要保证交换两个数不相等，交换之后指针不变
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            // [1,1] in this case the second 1, it is !=i+1 also not A[A[i]-1] != A[i]
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    // GIPlan
    
    public int firstMissingPositive(int[] A) {
        int i=0;
        while(i<A.length){
            if(A[i]==i+1||A[i]<=0||A[i]>A.length) i++;
            else if(A[i]!= A[A[i]-1]) swap(A,i,A[i]-1);
            else i++;
        }
        i=0;
        while(i<A.length&&A[i]==i+1){
            i++;
        }
        return i+1;
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

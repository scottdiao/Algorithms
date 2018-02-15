package leetcode;

//Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].
public class SearchforaRange {

    public int[] searchRange(int[] A, int target) {  
        int[] result = new int[2];  
        result[0] = getBoundRange(A, 0, A.length-1, target, true);  
        result[1] = getBoundRange(A, 0, A.length-1, target, false);  
        return result;  
    }  
    public int getBoundRange(int[]A, int l, int r, int target, boolean left){  
        if(l>r) return -1;  
        else{  
            int m = (l+r)/2;  
            if(A[m]==target){  
                if(left){  
                    if(m==0 || A[m-1]<target) return m;  
                    else return getBoundRange(A, l, m-1, target, left);  
                }else {  
                    if(m==A.length-1 || target<A[m+1]) return m;  
                    else return getBoundRange(A, m+1, r, target, left);  
                }  
            }  
            else if (A[m]>target) {  
                return getBoundRange(A, l, m-1, target, left);  
            }else {  
                return getBoundRange(A, m+1, r, target, left);  
            }  
        }  
    }  

}

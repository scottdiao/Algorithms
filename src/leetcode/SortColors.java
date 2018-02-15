package leetcode;

//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Note:
//You are not suppose to use the library's sort function for this problem.
//
//click to show follow up.
//
//Follow up:
//A rather straight forward solution is a two-pass algorithm using counting sort.
//First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
//
//Could you come up with an one-pass algorithm using only constant space?


public class SortColors {

    public static void main(String[] args) {
            int[] a = {0,2};
    }
    
    public void swap(int[] A, int a, int b) {  
        int tmp = A[a];  
        A[a] = A[b];  
        A[b] = tmp;  
    }  
      
    public void sortColors(int[] A) {  
        int len = A.length;  
        int i, r = 0, b = 0;  
        for (i = 0; i < len-b; i++) {  
            if (A[i] == 0) {  
                swap(A, i, r);  
                r++;  
            } else if (A[i] == 2) {  
                swap(A, i, len-1-b);  
                b++;  
                i--; //后面交换过来的元素也要进行判断  
            }   
        }  
    }  
    
//    Counting Sort
    public void sortColors(int[] A) {  
        int i, r, w, b;  
        r = w = b = 0;  
        for (i = 0; i < A.length; i++) {  
            if (A[i] == 0) r++;  
            else  if (A[i] == 1) w++;  
            else b++;  
        }  
        for (i = 0; i < A.length; i++) {  
            if (i < r) A[i] = 0;  
            else if (i < r + w) A[i] = 1;  
            else A[i] = 2;  
        }  
    } 
	
}

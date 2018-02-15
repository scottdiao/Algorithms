package Algorithms;
import java.io.Serializable;
/**
*
* @author Scott
*/
public class BinarySearch implements Serializable {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {1,2,3,3,3,4,5};
        
        
//        System.out.println(binarySearch(A,3));
        System.out.println(binarySearch(A,3));
        System.out.println(binarySearchFirstDuplicate(A,3));
        System.out.println(binarySearchLastDuplicate(A,3));

	}
    public static int binarySearch(int[] nums, int x){
        int low=0, mid=0, high = nums.length-1;
        while(low<high){
            mid=low+(high-low)/2;
            if(nums[mid]<x) low=mid+1;
            else if(nums[mid]>x) high=mid-1;
            else return nums[mid];
        }
        return  nums[low];
    }
    
    // return the first index
    public static int binarySearchFirstDuplicate(int[] nums, int x){
        int low=0, mid=0, high = nums.length-1;
        while(low<high){
            mid=low+(high-low)/2;
            if(nums[mid]<x) low=mid+1;
            else if(nums[mid]>=x) high=mid;
        }
        return  low;
    }
    
    // return the last index
    public static int binarySearchLastDuplicate(int[] nums, int x){
        int low=0, mid=0, high = nums.length-1;
        while(low<high){
            mid=low+(high-low)/2;
            if(nums[mid]<=x) low=mid;
            else if(nums[mid]>=x) high=mid-1;
        }
        return  low;
    }
}

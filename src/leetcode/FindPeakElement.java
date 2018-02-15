package leetcode;
//A peak element is an element that is greater than its neighbors.
//
//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//
//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
//You may imagine that num[-1] = num[n] = -∞.
//
//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//
//click to show spoilers.
public class FindPeakElement  {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
    
//  1 3 4 5 6 2 7 8 9
//          6>2
//    binarySearch(1 3 4<5 6)
//    binarySearch(5<6) 
    int binarySearch(int[] num, int low, int high){
        if(low == high)
            return low;
        else{
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
//            首先我们找到中间节点mid，如果大于两边返回当前index就可以了，如果左边的节点比mid大，那么我们可以继续在左半区间查找，
//            这里面一定存在一个peak，为什么这么说呢？假设此时的区间范围为[0, mid - 1]， 因为num[mid - 1]一定大于num[mid]了，
//            如果num[mid - 2] <= num[mid - 1]，那么num[mid - 1]就是一个peak。如果num[mid - 2] > num[mid - 1]，
//            那么我们就继续在[0, mid - 2]区间查找，因为num[-1]为负无穷，所以最终我们绝对能在左半区间找到一个peak。同理右半区间一样。
            if(num[mid1] > num[mid2])
                return binarySearch(num, low, mid1);
            else
                return binarySearch(num, mid2, high);
        }
    }
}

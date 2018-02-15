package leetcode;
/**
*
* @author Scott
*/
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max; 
    } 
    
    // by my self, a little dumb
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1&&count==0) count=1;
            if(i<nums.length-1&&nums[i]==1&&nums[i+1]==1) count++;
            else{
                res = Math.max(res, count);
                count =0;
            }
        }
        return res;
    }
}

package leetcode;
/**
*
* @author Scott
*/

enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGame  {
    public static void main(String[] args) {
            int[] a = new int[]{2,3,1,1,4};
            System.out.println(canJump(a));
    }

    public static boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i:nums){
            if(i<=maxJump&&i+nums[i]>=maxJump) maxJump = i+nums[i];
            System.out.println("max"+maxJump);
        }
       
        return maxJump >=nums.length-1;
    }
//   Greedy
//    public boolean canJump(int[] nums) {
//        int lastPos = nums.length - 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i + nums[i] >= lastPos) {
//                lastPos = i;
//            }
//        }
//        return lastPos == 0;
//    }
    
    
// Top down DP
//    Index[] memo;
//
//    public boolean canJumpFromPosition(int position, int[] nums) {
//        if (memo[position] != Index.UNKNOWN) {
//            return memo[position] == Index.GOOD ? true : false;
//        }
//
//        int furthestJump = Math.min(position + nums[position], nums.length - 1);
//        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//            if (canJumpFromPosition(nextPosition, nums)) {
//                memo[position] = Index.GOOD;
//                return true;
//            }
//        }
//
//        memo[position] = Index.BAD;
//        return false;
//    }
//
//    public boolean canJump(int[] nums) {
//        memo = new Index[nums.length];
//        for (int i = 0; i < memo.length; i++) {
//            memo[i] = Index.UNKNOWN;
//        }
//        memo[memo.length - 1] = Index.GOOD;
//        return canJumpFromPosition(0, nums);
//    }
//    
//    // DFS
//    public boolean canJumpFromPosition(int position, int[] nums) {
//        if (position == nums.length - 1) {
//            return true;
//        }
//
//        int furthestJump = Math.min(position + nums[position], nums.length - 1);
//       for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//            
//         for (int nextPosition = furthestJump; nextPosition > position; nextPosition--){
//            if (canJumpFromPosition(nextPosition, nums)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public boolean canJump(int[] nums) {
//        return canJumpFromPosition(0, nums);
//    }
//    
//
//// GIPlan
//    
//    public boolean canJump(int[] nums) {
//        int lastPos = nums.length-1;
//        for(int i=nums.length-1;i>=0;i--){
//            if(nums[i]+i>=lastPos) lastPos=i;
//        }
//        return lastPos==0;
//    }
    
}

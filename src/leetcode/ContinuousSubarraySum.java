package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
*
* @author Scott
*/
public class ContinuousSubarraySum {
// [23, 2, 4, 6, 7] k=6
//  i=0 runningSum = 23%6 = 5  map (5,0)
//  i=1 runningSum = 7%6 = 1   map (1,1)
//  i=2 runningSum = 5%6 = 5 prev = 0
    
//If we find that a running sum value at index j has been previously seen before in some earlier index i
//It means the sum between i and j is nk  
    
    public static void main(String[] args){
        int[] a = new int[]{0,1,0};
        System.out.println(checkSubarraySum(a,0));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k; 
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else{
                System.out.println("sum:"+runningSum+"i:"+i);
                map.put(runningSum, i);
            } 
        }
        return false;
    }
    
//    public static boolean checkSubarraySum(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int sum=0;
//        for(int i=0;i<nums.length;i++){
//            sum+=nums[i];
//            if(k!=0) sum%=k; //做%一定要判断不为0
//            int prev = map.getOrDefault(sum,-1);
//            if(prev!=-1&&i-prev>=1){
//                
//                return true;
//            }else{
//                System.out.println("sum:"+sum+"i:"+i);
//                map.put(sum,i);
//            }
//        }
//        return false;
//    }
    
}

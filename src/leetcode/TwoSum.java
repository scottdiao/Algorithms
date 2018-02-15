package leetcode;
import java.util.HashMap;
import java.util.Map;
/**
*
* @author Scott
*/
public class TwoSum  {
    
    //Brute Force
    
//    public int[] twoSum(int[] nums, int target) {
//        int n = nums.length;
//        for(int i = 0; i<n; i++){
//            for(int j=i+1; j<n ; j++){
//                if(nums[i] == target - nums[j]){
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{};
//        
//    }
    
    // one pass hash table
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};    
            }else{
                map.put(nums[i],i );
            }
        }
        return new int[]{};
        
    }
}

package leetcode;
/**
*
* @author Scott
*/
public class RangeAddition  {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates) {
           int value = update[2];
           int start = update[0];
           int end = update[1];
           // only set start end index with value sum
           res[start] += value;
           
           // if end is not the less onw, set -value so that the sum will decrese
           if(end < length - 1)
               res[end + 1] -= value;

       }

       int sum = 0;
       for(int i = 0; i < length; i++) {
           sum += res[i];
           res[i] = sum;
       }

       return res;
    }
}

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
*
* @author Scott
*/

//Sort the array. Ascend on width and descend on height if width are same.
//Find the longest increasing subsequence based on height.
public class RussianDollEnvelopes  {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 
           || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
           } 
        });
//        LIS
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }
    
//    GIPlan 一次过有脾气吗操！
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0||envelopes[0]==null||envelopes[0].length!=2) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                else return o1[0]-o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int len =0;
        for(int[] e : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, e[1]);
            if(index<0) index = -index -1;
            dp[index] = e[1];
            if(index == len) len ++;
        }
        return len;
    }
    
}

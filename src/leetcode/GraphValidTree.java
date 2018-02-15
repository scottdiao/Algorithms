package leetcode;

import java.util.Arrays;

/**
*
* @author Scott
*/
public class GraphValidTree  {
//     [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
//    [-1,-1,-1,-1,-1] x=0 y=1
//    [1,-1,-1,-1,-1] x=1 y=2
//    [1,2,-1,-1,-1] x=2 y=3
//    [1,2,3,-1,-1] x=3 y=3  there is a cycle
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}

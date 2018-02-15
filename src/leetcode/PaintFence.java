package leetcode;
/**
*
* @author Scott
*/
public class PaintFence  {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
//the last two posts have different colors, and the number of ways in this case is diffColorCounts
        int diffColorCounts = k*(k-1);
//the last two posts have the same color, the number of ways to paint in this case is sameColorCounts
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
//very time we encounter a new post, we check if the it is as same as the previous posts ,
//if they are differnt, it will be the total of previous one * k-1
//if they are the same, if must be the previous diffcolor
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }
}

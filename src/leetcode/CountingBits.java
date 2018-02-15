package leetcode;
/**
*
* @author Scott
*/
public class CountingBits  {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        // Small DP problem check >>1 number plus the last bit
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}

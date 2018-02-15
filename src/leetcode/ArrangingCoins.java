package leetcode;
/**
*
* @author Scott
*/
public class ArrangingCoins  {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = (start + end) >>> 1;
            // 1 + 2 + 3 + 4 + 5 + 6 + 7 + ... + x <= n`
            // `(x * ( x + 1)) / 2 <= n`
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }
}

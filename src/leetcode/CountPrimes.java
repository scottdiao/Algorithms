package leetcode;
/**
*
* @author Scott
*/
// Count the number of prime numbers less than a non-negative number, n.
public class CountPrimes  {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (notPrime[i] == false) {
                count++;
                // 如果找到一个质数，那么它的倍数都不是质数了
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}

package leetcode;
/**
*
* @author Scott
*/
public class SumofSquareNumbers  {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            // sqrt function cost log(n)
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) // to see if b is int
                return true;
        }
        return false;
    }
}

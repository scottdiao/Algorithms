package leetcode;
/**
*
* @author Scott
*/
Strobogrammatic Number II give us all the strings with length n, then we can call it to get strings with length between low.length() and high.length(), and remove the strings that less than low and larger than high.


public class StrobogrammaticNumberIII {
    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public int strobogrammaticInRange(String low, String high) {
        int[] count = {0};
        for (int len = low.length(); len <= high.length(); len++) {
            //Construct char arrays from low.length() to high.length()
            char[] c = new char[len];
            dfs(low, high, c, 0, len - 1, count);
        }
        return count[0];
    }

    public void dfs(String low, String high , char[] c, int left, int right, int[] count) {
        if (left > right) {
            //When left > right, add eligible count
            String s = new String(c);
            //Although length is right, but the value is not in range
            if ((s.length() == low.length() && s.compareTo(low) < 0) || 
                (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            count[0]++;
            return;
        }
        for (char[] p : pairs) {
            //Add stro pairs from outside
            c[left] = p[0];
            c[right] = p[1];
            //010 = 10 which is not a stro number
            if (c.length != 1 && c[0] == '0') {
                continue;
            }
            if (left == right && p[0] != p[1]) {
                continue;
            }
            dfs(low, high, c, left + 1, right - 1, count);
        }
    }
}

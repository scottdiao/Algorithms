package leetcode;
/**
*
* @author Scott
*/
public class FirstBadVersion{

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2; // avoid overflow
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;            
        }        
        return start;
    }
}

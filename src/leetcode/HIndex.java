package leetcode;
/**
*
*  Bucket sort
*/
public class HIndex  {
//    citations = [3, 0, 6, 1, 5]
//    buckets =   [1, 1, 0, 1, 0, 2]
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}

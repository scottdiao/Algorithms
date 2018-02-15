package leetcode;
/**
*
* @author Scott
*/
public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        // why +1, because we don't need to test the last row, if the pig survive, then the posion is in the last row 
        while( Math.pow((minutesToTest / minutesToDie + 1) , pigs) < buckets)
            pigs += 1;
        return pigs;
    }
}

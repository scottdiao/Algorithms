package leetcode;

import java.util.HashSet;

/**
*
* @author Scott
*/
public class DistributeCandies  {
    public int distributeCandies(int[] candies) {
        HashSet < Integer > set = new HashSet < > ();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}

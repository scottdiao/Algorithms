package leetcode;

import java.util.HashSet;

//The idea is quite simple. If there exists a line reflecting the points,
//then each pair of symmetric points will have their x coordinates adding up to the same value,
//including the pair with the maximum and minimum x coordinates. So, in the first pass,
//I iterate through the array, adding each point to the hash set,
//and keeping record of the minimum and maximum x coordinates.
//Then, in the second pass, I check for every point to the left of the reflecting line,
//if its symmetric point is in the point set or not. If all points pass the test, 
//then there exists a reflecting line. Otherwise, not.

//By the way, here, to hash the content of an array, rather than the reference value,
//I use Arrays.hashCode(int[]) first, and then re-hash this hash code.
//You can also use Arrays.toString(int[]) to first convey the 2d array to a string, 
//and then hash the string. But the second method is slower.
public class LineReflection  {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(int[] p:points){
            max = Math.max(max,p[0]);
            min = Math.min(min,p[0]);
            // we need a char to seprate x and y
            String str = p[0] + "a" + p[1];
            set.add(str);
        }
        int sum = max+min;
        for(int[] p:points){
            //int[] arr = {sum-p[0],p[1]};
            // for each pair, y must be the same
            String str = (sum-p[0]) + "a" + p[1];
            if( !set.contains(str))
                return false;

        }
        return true;
    }
}

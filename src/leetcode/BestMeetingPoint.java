package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
*
* @author Scott
*/
public class BestMeetingPoint  {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
//      we don't need to sort rows since it already sorted
        int row = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }
// In fact, the median must be the optimal meeting point
// As long as there is equal number of points to the left and right of the meeting point, the total distance is minimized.
    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }
}

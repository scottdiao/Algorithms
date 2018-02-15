package leetcode;

import java.util.HashMap;
import java.util.Map;

//Scan each row. If that row has N black pixels, put a string signature, which is concatenation of each characters in that row, as key and how many times we see that signature into a HashMap. Also during scan each row, we record how many black pixels in each column in an array colCount and will use it in step 2.
//For input:
//[['W', 'B', 'W', 'B', 'B', 'W'],
//['W', 'B', 'W', 'B', 'B', 'W'],
//['W', 'B', 'W', 'B', 'B', 'W'],
//['W', 'W', 'B', 'W', 'B', 'B']]
//We will get a HashMap:
//{"WBWBBW": 3, "WWBWBB": 1}
//and colCount array:
//[0, 3, 1, 3, 4, 1]
//Go through the HashMap and if the count of one signature is N, those rows potentially contain black pixels we are looking for. Then we validate each of those columns. For each column of them has N black pixels (lookup in colCount array), we get N valid black pixels.
//For above example, only the first signature "WBWBBW" has count == 3. We validate 3 column 1, 3, 4 where char == 'B', and column 1 and 3 have 3 'B', then answer is 2 * 3 = 6.
//

public class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        if (m == 0) return 0;
        int n = picture[0].length;
        if (n == 0) return 0;
        
        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[n];
        
        for (int i = 0; i < m; i++) {
            String key = scanRow(picture, i, N, colCount);
            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int result = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < n; j++) {
                    if (key.charAt(j) == 'B' && colCount[j] == N) {
                        result += N;
                    }
                }
            }
        }
        
        return result;
    }
    
    private String scanRow(char[][] picture, int row, int target, int[] colCount) {
        int n = picture[0].length;
        int rowCount = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < n; j++) {
            if (picture[row][j] == 'B') {
                rowCount++;
                colCount[j]++;
            }
            sb.append(picture[row][j]);
        }
        
        if (rowCount == target) return sb.toString();
        return "";
    }
}

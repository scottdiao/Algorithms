package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Scott
*/
public class FlipGame  {
    public List<String> generatePossibleNextMoves(String s) {
         List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
//      substring do not include right bound, ending index exclusive
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return list;
    }
}

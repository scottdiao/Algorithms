package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

/**
*
* @author Scott
*/
public class FlipGameII  {
//  naive backtracking
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
          return false;
        }

        for (int i = 0; i < s.length() - 1; i++) {
          if (s.startsWith("++", i)) {
            String t = s.substring(0, i) + "--" + s.substring(i + 2);

            if (!canWin(t)) {
              return true;
            }
          }
        }
        return false;
    }
    
// With DP
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        HashMap<String, Boolean> winMap = new HashMap<>();
        return helper(s, winMap);
    }

    public boolean helper(String s, HashMap<String, Boolean> winMap) {
        if (winMap.containsKey(s)) {
            return winMap.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i+2);
                if (!helper(t, winMap)) {
                    winMap.put(s, true);
                    return true;
                }
            }
        }
        winMap.put(s, false);
        return false;
    }
    
//   SG Function
    int firstMissingNumber(Set<int> lut) {
        int m = lut.size();
        for (int i = 0; i < m; ++i) {
            if (lut.count(i) == 0) return i;
        }
        return m;
    }

    boolean canWin(String s) {
        int curlen = 0, maxlen = 0;
        List<Integer> board_init_state = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {    
            if (s.charAt(i) == '+') curlen++;              // Find the length of all continuous '+' signs
            if (i+1 == s.length() || s.charAt(i) == '-') {
                if (curlen >= 2) board_init_state.add(curlen);    // only length >= 2 counts
                maxlen = Math.max(maxlen, curlen);       // Also get the maximum continuous length
                curlen = 0;
            }
        }          // For instance ++--+--++++-+ will be represented as (2, 4)
        Vector<Integer> g(maxlen+1, 0);    // Sprague-Grundy function of 0 ~ maxlen
        for (int len = 2; len <= maxlen; ++len) {
            unordered_set<int> gsub;    // the S-G value of all subgame states
            for (int len_first_game = 0; len_first_game < len/2; ++len_first_game) {
                int len_second_game = len - len_first_game - 2;
                // Theorem 2: g[game] = g[subgame1]^g[subgame2]^g[subgame3]...;
                gsub.insert(g[len_first_game] ^ g[len_second_game]);
            }
            g[len] = firstMissingNumber(gsub);
        }

        int g_final = 0;
        for (auto& s: board_init_state) g_final ^= g[s];
        return g_final != 0;    // Theorem 1: First player must win iff g(current_state) != 0
     }

}

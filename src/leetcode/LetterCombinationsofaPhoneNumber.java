package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
*
* @author Scott
*/
public class LetterCombinationsofaPhoneNumber  {
    
    // This is actully a BFS solution
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();  // A queue
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        StringBuilder sb = new StringBuilder();
        // ""
        // iteration 1 i=0 'a'->'b'->'c'  
        // iteration 2 i=1 'a'->'b'->'c' 
//                         'b'->'c'->'ad'->'ae'->'af' 
//                         'c'->'ad'->'ae'->'af'->'bd'->'be'->'bf'
//                         'ad'->'ae'->'af'->'bd'->'be'->'bf'->'cd'->'ce'->'cf'
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){ //get the first element
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
    
    // DFS
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
            List<String> ret = new LinkedList<String>();
            combination("", digits, 0, ret);
            return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
            if (offset >= digits.length()) {
                ret.add(prefix);
                return;
            }
            String letters = KEYS[(digits.charAt(offset) - '0')];
            for (int i = 0; i < letters.length(); i++) {
                combination(prefix + letters.charAt(i), digits, offset + 1, ret);
            }
    }
    
    // GIPlan
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<String>();  // A queue
        if(digits == null||digits.equals("")) return queue;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.add("");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(queue.peek().length()==i){
                String temp = queue.poll();
                for(char c : mapping[x].toCharArray()){
                    queue.offer(temp+c);
                }
            }
        }
        return queue;
    }
}

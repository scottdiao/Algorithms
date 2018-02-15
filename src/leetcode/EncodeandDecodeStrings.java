package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import static leetcode.BasicCalculatorII.calculate;

/**
*
* @author Scott
*/
public class EncodeandDecodeStrings {
    public static void main (String[] args){
        List<String> strs = new LinkedList<>();
        strs.add("abc");
        strs.add("dgdfs");
        strs.add("bgadgc");
        System.out.println(encode(strs));
    }
     // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }
}

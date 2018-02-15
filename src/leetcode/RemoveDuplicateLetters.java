package leetcode;
/**
*
* @author Scott
*/
public class RemoveDuplicateLetters  {
    public static void main(String[] args){
        System.out.println(removeDuplicateLetters("eecbae"));
    }
    // lexicographical order 字典排序， 保持字符在原字符串的相对顺序
    // eecbae
    // d + cba
    public static String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}

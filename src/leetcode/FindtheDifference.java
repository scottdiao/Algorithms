package leetcode;
/**
*
* @author Scott
*/
public class FindtheDifference  {
    public static void main(String[] args){
        findTheDifference("abc","abcde");
    }
    public static char findTheDifference(String s, String t) {
	char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        c ^= t.charAt(t.length() - 1);
        return c;
    }
    
    //GIPlan
    public static char findTheDifference(String s, String t) {
        char c = 0;
        for(int i=0;i<s.length();i++){
            c^=s.charAt(i);
            c^=t.charAt(i);
        }
        c^=t.charAt(t.length()-1);
        return c;
    }
}

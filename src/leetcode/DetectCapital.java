package leetcode;
/**
*
* @author Scott
*/
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}

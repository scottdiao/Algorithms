package leetcode;
//
//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome.


public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isPalindrome(String s) {
		if (s == null)
            return false;
        if (s.length() == 0)// we define empty string as valid palindrome.
            return true;
        int low = 0, high = s.length() - 1;
        s = s.toLowerCase();
        while (low < high) {
            while (low < high && !Character.isLetterOrDigit(s.charAt(low)))
                low++;
    
            while (low < high && !Character.isLetterOrDigit(s.charAt(high)))
                high--;
    
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

}

package leetcode;
/**
*
* @author Scott
*/

public class PalindromeNumber  {
    public static void main(String[] args) {
        isPalindrome(10);
    }
    
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
    
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int digit=0, num=0, temp=x;
        while(temp!=0){
            digit=temp%10;
            num = num*10+digit;
            temp/=10;
        }
        return num==x;
    }
}

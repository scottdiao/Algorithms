package leetcode;

//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//Example:
//
//Input: "Hello World"
//Output: 5

public class LengthofLastWord {
    public static void main(String[] args) {
            String a = "a  ";
            System.out.println(lengthOfLastWord(a));
    }
    public static int lengthOfLastWord(String s) {
        if(s==null||s.equals("")){
            return 0;
        }
        char[] c = s.toCharArray();
        int count=0, i =c.length-1;
        while(i>=0&&c[i]==' ') i--;
        while(i>=0){
            if(c[i--]!=' '){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}

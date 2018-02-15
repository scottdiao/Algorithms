package leetcode;

//Given an input string, reverse the string word by word.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//
//Update (2015-02-12):
//For C programmers: Try to solve it in-place in O(1) space.
//
//click to show clarification.
//
//Clarification:
//What constitutes a word?
//A sequence of non-space characters constitutes a word.
//Could the input string contain leading or trailing spaces?
//Yes. However, your reversed string should not contain leading or trailing spaces.
//How about multiple spaces between two words?
//Reduce them to a single space in the reversed string.

 
public class ReverseWordsinaString  {
    public static void main(String[] args) {
            String a = " 1";
            reverseWords(a);
    }
    
    public static String reverseWords(String s) {
        if(s==null||s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split("\\s+");  //多个空格之分割一次，一个或多个空格
        System.out.println("1:"+strArr[0]);
        System.out.println("2:"+strArr[1]);
        for(int i=strArr.length-1;i>0;i--){
          sb.append(strArr[i]);
          sb.append(" ");
        }
        //最后一个词不append “ ”
        if(strArr.length>0){
          sb.append(strArr[0]);
        }
        return sb.toString();
    }
//    public static String reverseWords(String s) {
//        String[] parts = s.trim().split("\\s+");
//        String out = "";
//        for (int i = parts.length - 1; i > 0; i--) {
//            out += parts[i] + " ";
//        }
//        //for the last part we don't need " " as trail
//        return out + parts[0];
//    }
}

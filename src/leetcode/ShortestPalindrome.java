package leetcode;
//
//Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
//Find and return the shortest palindrome you can find by performing this transformation.
//
//For example:
//
//Given "aacecaaa", return "aaacecaaa".
//
//Given "abcd", return "dcbabcd".


public class ShortestPalindrome {
    public static void main(String[] args){
        System.out.println( shortestPalindrome("catacb"));
    }
//    input:catacb temp: catacb # bcatac
//    KMP  
// 思路我们用KMP找 c a t a c b # b c a t a c
// 和            a t a c b # b c a t a c 匹配的substring
// 目的是为了在temp c a t a c b # b c a t a c 中找相同的prefix 和 postfix
//    c a t a c b # b c a t a c
//    0 0 0 0 1 0 0 0 1 2 3 4 5

    public static String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);

        //get the maximum palin part in s starts from 0
        System.out.println(table[table.length - 1]);
        System.out.println(new StringBuilder(s.substring(table[table.length - 1])).reverse().toString());
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }
    //int[] table 存储到当前字符为止有多少个字符已经匹配上
    public static int[] getTable(String s){
        //get lookup table
        int[] table = new int[s.length()];

        //pointer that points to matched char in prefix part

        int index = 0;
        //skip index 0, we will not match a string with itself
        //把s 和 s错一位比
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
                //we can extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index ++;
            }else{
                //match failed, we try to match a shorter substring

                //by assigning index to table[i-1], we will shorten the match string length, and jump to the 
                //prefix part that we used to match postfix ended at i - 1
                //如果发现不匹配，我们不需要从index+1再开始算，由于匹配字符串指针i-1为止一共有table[i-1]个匹配字符
                index = table[i-1];

                while(index > 0 && s.charAt(index) != s.charAt(i)){
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index-1];
                }

                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if(s.charAt(index) == s.charAt(i)){
                    //if match, then extend one char 
                    index ++ ;
                }

                table[i] = index;
            }
        }
        return table;
    }
}

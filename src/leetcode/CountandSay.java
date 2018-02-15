package leetcode;

//The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth term of the count-and-say sequence.
//
//Note: Each term of the sequence of integers will be represented as a string.

public class CountandSay {
    
    public static void main(String[] args) {
            System.out.println(countAndSay(111));
            System.out.println("*******");
    }

    
      
    public static String countAndSay(int n) {  
        String result = "1";  
        int i = 1;  
        while(i<n) {  
            result = countAndSayForOneString(result);  
            i++;  
        }  
        return result;  
    }  
    
    static String  countAndSayForOneString(String input) {  
        char tmp = input.charAt(0);  
        int  num = 1;  
        StringBuilder newString = new StringBuilder("");  
        for(int k=1;k<input.length();k++) {  
            if(input.charAt(k)==tmp) {  
                num++;  
                continue;  
            }  
            newString.append(Integer.toString(num)).append(tmp);  
            tmp = input.charAt(k);  
            num = 1;  
        }  
        newString.append(Integer.toString(num)).append(tmp);  
        return newString.toString();  
    }  

}

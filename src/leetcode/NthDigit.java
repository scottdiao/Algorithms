package leetcode;
/**
*
* @author Scott
*/
public class NthDigit  {
    public static void main(String[] args){
        findNthDigit(55);
    }
     public static int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
         System.out.println(start);
         System.out.println((n - 1) / len);
//      for example len=2  n=55      (n-1)/len means how many number in len 2
        start += (n - 1) / len;
        System.out.println(start);
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}

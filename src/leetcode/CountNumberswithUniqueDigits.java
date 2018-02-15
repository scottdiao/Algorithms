package leetcode;
/**
*
* @author Scott
*/
//https://leetcode.com/problems/count-numbers-with-unique-digits/?tab=Solutions
public class CountNumberswithUniqueDigits  {
     public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;
        
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}

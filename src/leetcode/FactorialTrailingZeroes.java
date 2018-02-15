package leetcode;
//
//Given an integer n, return the number of trailing zeroes in n!.
//
//Note: Your solution should be in logarithmic time complexity.


//This question is pretty straightforward.
//
//Because all trailing 0 is from factors 5 * 2.
//
//But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors. In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.
// 25!=25*24*23*22*21*20*19*18*17*16*15*14*13*12*11*10*9*8*7*6*5*4*3*2*1
public class FactorialTrailingZeroes{
    public static void main(String[] args){
        System.out.println(trailingZeroes(25));
    }
            
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

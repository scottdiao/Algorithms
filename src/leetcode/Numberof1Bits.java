package leetcode;
//
//Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
//
//For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.


public class Numberof1Bits  {
    public static int hammingWeight(int n) {
	int ones = 0;
    	while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
    	}
    	return ones;
    }
    
    //Brian Kernighan’s way
    //n &= (n - 1) 会将最后一个1bit清0， 然后sum++直到全部为零
    // 110000100  n
    // 110000011  n-1
    // 110000000  n &= (n - 1)
    //n & (n – 1) will clear the last significant bit set
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}

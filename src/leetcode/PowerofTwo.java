package leetcode;
/**
*
* @author Scott
*/
Given an integer, write a function to determine if it is a power of two.
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n-1))==0 && n>0);
    }
}

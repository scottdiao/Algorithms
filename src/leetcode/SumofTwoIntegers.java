package leetcode;
/**
*
* @author Scott
*/
public class SumofTwoIntegers  {
    // Iterative
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b; //1+1=10
            a = a ^ b;          //0+1=1  1+0=1
            b = carry << 1;
        }

        return a;
    }
    
    public int getSubtract(int a, int b) {
	while (b != 0) {
		int borrow = (~a) & b;
		a = a ^ b;
		b = borrow << 1;
	}
	
	return a;
}
}

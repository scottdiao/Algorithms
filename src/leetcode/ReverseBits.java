package leetcode;

//Reverse bits of a given 32 bits unsigned integer.
//
//For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
//return 964176192 (represented in binary as 00111001011110000010100101000000).
//
//Follow up:
//If this function is called many times, how would you optimize it?
//
//Related problem: Reverse Integer

// 要牢记  >>sign shift就是/2   >>>unsigned shift 连着第一位一块移动
public class ReverseBits  {
    //  1011       i=0 res = 1    n = 101 res = 10
//                 i=1 res = 11   n = 10 res = 110
//                 i=2 res = 110  n = 1  res = 1100
//                 i=3 res = 1101 
    public static void main(String[] args){
        System.out.println(-4>>>2);
    }                       
    
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1; // only get the last bit
            n >>>= 1;   // CATCH: must do unsigned shift
            //由于每次循环result都多左移一位，所以只需要iterate 31 次
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }
    // GIPlan
    public int reverseBits(int n) {
        int result =0;
        for(int i=0;i<32;i++){
            result += n&1;
           n>>>=1;
            if(i<31) result <<=1;
        }
        return result;
    }
}

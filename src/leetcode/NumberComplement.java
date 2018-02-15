package leetcode;
/**
*
* @author Scott
*/
public class NumberComplement  {
    public static void main(String[] args){
        System.out.println(~-2);
    }
//    5 is actcually 00000101, ~ will reverse all 0s
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}

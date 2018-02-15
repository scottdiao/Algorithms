package leetcode;
//
//Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class SingleNumberII  {
    public int singleNumber(int[] A) {
        int a = 0, b = 0;
        for(int i = 0; i < A.length; i++){

            a = (a ^ A[i]) & ~b; // for the first occurance of number, store in ones
            b = (b ^ A[i]) & ~a; // for the second occurance of number, store in twos
        }
        return a;
    }
    
    
// Easy to understand
//    current   incoming  next
//    a b            c    a b
//    0 0            0    0 0
//    0 1            0    0 1
//    1 0            0    1 0
//    0 0            1    0 1
//    0 1            1    1 0
//    1 0            1    0 0
     public int singleNumber(int[] nums) {
        //we need to implement a tree-time counter(base 3) that if a bit appears three time ,it will be zero.
        //#curent  income  ouput
        //# ab      c/c       ab/ab
        //# 00      1/0       01/00
        //# 01      1/0       10/01
        //# 10      1/0       00/10
        // a=~abc+a~b~c;
        // b=~a~bc+~ab~c;
        int a=0;
        int b=0;
        for(int c:nums){
            // temp暂时储存a的值，因为a会影响b所以现在不能改变a的值
            int temp=(~a&b&c)|(a&~b&~c);
            b=(~a&~b&c)|(~a&b&~c);
            a=temp;
        }
        //we need find the number that is 01,10 => 1, 00 => 0.
        //return the bit if this bit occurs one or two times
        //如果a是1代表这个bit出现过一次， b是1代表出现过两次
        return a|b;
        
    }
}

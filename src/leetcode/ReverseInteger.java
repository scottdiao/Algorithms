package leetcode;

//     example int x =15    
//            tail =15%10=5
//            newresult = 0+5 = 5
//            result = 5
//            x=15/10=1
//
//            tail = 1
//            newResult =51
//            50/10 = 5 =5

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
	
	public static int reverse(int x) {
            int result = 0;
            while (x != 0)
            {
                int tail = x % 10;
                int newResult = result * 10 + tail;
//                System.out.println(newResult);
                if ((newResult - tail) / 10 != result)  // check if newResult exceed the max value which is 2147483647 2.^31-1
                   return 0; 
                result = newResult;
                x = x / 10;
            }
    
            return result;
        }
        
        //妈的一次过 重拾男人往日的自信
         public int reverse(int x) {
            long res =0;
            int sign=x<0?-1:1;
            x = Math.abs(x);
            while(x>0){
                res = 10*res+x%10;
                if(res>=Integer.MAX_VALUE) return 0;
                x/=10;
            }
            return (int)res*sign;
        }
}

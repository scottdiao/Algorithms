package leetcode;
/**
*
* @author Scott
*/
public class PerfectNumber  {
     public static void main(String[] args) {
            checkPerfectNumber(28);
    }
      public static boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                System.out.println("i:"+i);
                
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
                System.out.println("sum:"+sum);

            }
        }
        return sum - num == num;
    }
}

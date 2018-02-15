package leetcode;
/**
*
* @author Scott
*/
public class Pow  {
    
    public static void main(String[] args){
        System.out.println(-2%2);
    }
     public double myPow(double x, int m) {
        if (m == 0) return 1.0;  
        double half = myPow(x, m/2);  
        if (m%2 == 0)  
        {  
            return half*half;  
        }  
        else if (m>0)  
        {  
            return half*half*x;  
        }  
        else  
        {  
            return half*half/x;  
        }  
     }
}

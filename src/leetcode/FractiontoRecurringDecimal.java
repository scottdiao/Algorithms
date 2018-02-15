package leetcode;

import java.util.HashMap;

//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//If the fractional part is repeating, enclose the repeating part in parentheses.
//
//For example,
//
//Given numerator = 1, denominator = 2, return "0.5".
//Given numerator = 2, denominator = 1, return "2".
//Given numerator = 2, denominator = 3, return "0.(6)".

public class FractiontoRecurringDecimal  {
     public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        
        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
//        2/3=0.666
//       20/3=6   20%3=2
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            //除法数论，如果有相同那么这之间的几个数会无限循环
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
     
     // GIPlan
     public String fractionToDecimal(int numerator, int denominator) {
         if(numerator ==0) return "0";
         StringBuilder sb = new StringBuilder();
         sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : ""); // XOR to judge sign
         long num = Math.abs((long)numerator);  // long convertion should be in the ()
         long den = Math.abs((long)denominator);
         sb.append(num/den);
         num%=den;
         if(num==0) return sb.toString();
         HashMap<Long, Integer> map = new HashMap();
         sb.append(".");
         map.put(num, sb.length());
         
         while(num!=0){
            num*=10;
            sb.append(num/den);
            num%=den;
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }else{
                map.put(num, sb.length());
            }
         }
         return sb.toString();
    }
}

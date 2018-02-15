package leetcode;
/**
*
* @author Scott
*/

/*n=numRows
Δ=2n-2    1                           2n-1                         4n-3  i=0
Δ=        2                     2n-2  2n                    4n-4   4n-2  i=1
Δ=        3               2n-3        2n+1              4n-5       .     i=2
Δ=        .           .               .               .            .     
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
*/

public class ZigZagConversion   {
    public String convert(String s, int numRows) {
        
        if(s == null || s.length()==0 || numRows <=0)  
            return "";  
        if(numRows == 1)  
            return s;
            
        StringBuilder res = new StringBuilder();  
        int size = 2*numRows-2;  
        for(int i=0;i<numRows;i++){  
            for(int j=i;j<s.length();j+=size){  
                res.append(s.charAt(j));  
                if(i != 0 && i != numRows - 1){//except the first row and the last row
                    int temp = j+size-2*i;
                    if(temp<s.length())
                        res.append(s.charAt(temp));
                }
            }                  
        }  
        return res.toString();  
    }
}

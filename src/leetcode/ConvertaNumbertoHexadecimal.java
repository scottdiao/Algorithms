package leetcode;
/**
*
* @author Scott
*/
public class ConvertaNumbertoHexadecimal  {
    public static void main(String[] args){
        char c = 'a'+1;
        System.out.println(c);
    }
    
    
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            // 15 is the last 4 bit
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
    
    
    // Can not deal with negative value
    public static String toHex(int num) {
        int res;
        StringBuilder sb = new StringBuilder();
        while(num>0){
            res=num%16;
            if(res>=10) sb.append((char)('a'+res-10));
            else sb.append(res);
            num/=16;
        }
        return sb.reverse().toString();
    }
}

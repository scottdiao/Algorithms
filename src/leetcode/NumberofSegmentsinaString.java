package leetcode;
/**
*
* @author Scott
*/
public class NumberofSegmentsinaString  {
    public int countSegments(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                res++;        
        return res;
    }
    
    
    
    public int countSegments(String s) {
        if(s.equals("")||s==null) return 0;
        int count=0;
        if(s.charAt(0)!=' ') count = 1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=' '&&count ==0) count = 1;
            if(s.charAt(i)==' '&&s.charAt(i+1)!=' ') count++;
        }
        return count;
    }
}

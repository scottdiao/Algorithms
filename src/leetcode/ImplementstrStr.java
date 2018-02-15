package leetcode;
/**
*
* @author Scott
*/
public class ImplementstrStr  {
    
    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issi"));
		
    }
    
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0; // edge case: "",""=>0  "a",""=>0
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            for (int j = 0; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++)
                if (j == needle.length() - 1) return i;
        return -1;
    }
    
//    TLE
//    public static int strStr(String haystack, String needle) {
//        if(needle.equals("")||needle==null){
//            return 0;
//        }
//        if(needle.length()>haystack.length()){
//            return -1;
//        }
//        char hs[] = haystack.toCharArray();
//        char ns[] = needle.toCharArray();
//        int j=0,k=0;
//        for(int i=0;i<=hs.length-ns.length;i++){      // This is the key, no need to interate all 
//            if(hs[i]==ns[j]){
//                k=i;
//                while(j<ns.length&&k<hs.length&&hs[k]==ns[j]){
//                    System.out.println("k="+k);
//                    k++;
//                    j++;
//                } 
//                if(j==ns.length) return i;
//                j=0;
//            }
//        }
//        return -1;
//    }
}

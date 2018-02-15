package leetcode;

public class NeedleinHaystack {

	public static void main(String[] args) {

	}
	
	public int strStr(String haystack, String needle) {
		 	char[] h = haystack.toCharArray();
	        char[] n = needle.toCharArray();
	        if(haystack.equals(needle)){
	        	return 0;
	        }
	        if(haystack.equals("")){
	        	return -1;
	        }else if(needle.equals("")){
	        	return 0;
	        }
	        if(n.length>h.length){
	        	return -1;
	        }
	        int res=0;
	        for(int i=0;i<h.length;i++){
	        	if(h[i]==n[0]){
	        		for(int j=0;j<n.length;j++){
	        		    if(i+j>h.length-1){
	        				return -1;
	        			}
	        			if(h[i+j]!=n[j]){
	        				break;
	        			}
	        			if(j==n.length-1){
	        			    return i;
	        			}
	        		}
	        		
	        	}
	        	
	        	
	        }
	        return -1;
	    
    }

}

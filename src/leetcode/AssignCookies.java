package leetcode;

import java.util.Arrays;

/**
*
* @author Scott
*/
public class AssignCookies  {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i<g.length && j<s.length;j++) {
            // only after content i child can move to i+1 child, since they already sorted
            if(g[i]<=s[j]) i++;
        }
        return i;
    }
}

package leetcode;

import java.util.Stack;

/**
*
* @author Scott
*/
public class TrappingRainWater  {
    public static void main(String[] args){
        int[] a = {5,4,3,2,7};
        System.out.println("result"+trap(a));
        
    }
//    // Two pointer
    public int trap(int[] A) {
        if (A.length < 3) return 0;

        int ans = 0;
        int l = 0, r = A.length - 1;

        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1]) l++;
        while (l < r && A[r] <= A[r - 1]) r--;

        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }
    
    //Stack
    public static int trap(int[] A) {
        if (A==null) return 0;
        Stack<Integer> s = new Stack<>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            // keep pushing descending order
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++); // only i++ in this case
            }else {
                // in this case we don't add i
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                        //A[s.peek()] is the left, A[i] is the right, calc the min
                0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
    
    
    //dp not work
    public int trap(int[] A) {
        int leftMax =0 , rightMax=0, ans=0 ,leftIndex=0, rightIndex=0;
        int[] dp1 = new int[A.length];
        int[] dp2 = new int[A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<i;j++){
                if(A[j]>=leftMax){
                    leftMax = A[j];
                    leftIndex = j;
                }
            }
            if(A[i]<leftMax) dp1[i] = leftMax;
            leftMax=0;
            for(int j=A.length-1;j>i;j--){
                rightMax=Math.max(A[j], rightMax);
            }
            if(A[i]<rightMax) dp2[i] = rightMax;
            rightMax=0;
            if(dp1[i]!=0&&dp2[i]!=0) ans += dp1[i]+dp2[i];
        }
        return ans;
    }
}

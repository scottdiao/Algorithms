package leetcode;

import java.util.Stack;

//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
//find the area of largest rectangle in the histogram.
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//For example,
//Given heights = [2,1,5,6,2,3],
//return 10.


public class LargestRectangleinHistogram  {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
//          if the bar height is ascending, keep pushing to the stack
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                // 只需要计算tp的面积，然后从栈中除去tp，所以是i - 1 - s.peek()
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//              keep i the same, continue compare to stack peek until it higher than it 
                i--;
            }
        }
        return maxArea;
    }
}

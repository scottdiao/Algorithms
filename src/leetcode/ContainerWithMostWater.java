package leetcode;

//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
//n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//Note: You may not slant the container and n is at least 2.
public class ContainerWithMostWater  {
    
    //Brute Force
//    public int maxArea(int[] height) {
//        int maxarea = 0;
//        for (int i = 0; i < height.length; i++)
//            for (int j = i + 1; j < height.length; j++)
//                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
//        return maxarea;
//    }
    
//    Two pointer 
// 这个思想的精髓是先按长方形面积的底边排序， 再按照两边最短的边排序
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
    
}

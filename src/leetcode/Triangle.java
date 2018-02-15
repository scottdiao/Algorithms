package leetcode;

import java.util.List;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).



//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]

//A[0]=min(A[0]+A[1])+4=4 
//A[1]=min(A[1]+A[2])+1=1
//A[2]=min(A[2]+A[3])+8=8
//A[3]=min(A[3]+A[4])+3=3
//A[0]=min(A[0]+A[1])+6
public class Triangle {
//    O(1)
//    public int minimumTotal(List<List<Integer>> triangle) {
//        for(int i = triangle.size() - 2; i >= 0; i--)
//            for(int j = 0; j <= i; j++)
//                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
//        return triangle.get(0).get(0);
//    }
//    
//   O(n)
    
    // 从下往上，数组存储path sum, 数组会原来越小最后只剩下A[0]
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
//                A[j],A[j+1] are the pre row
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}



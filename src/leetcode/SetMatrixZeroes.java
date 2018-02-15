package leetcode;

//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
//click to show follow up.
//
//Follow up:
//Did you use extra space?
//A straight forward solution using O(mn) space is probably a bad idea.
//A simple improvement uses O(m + n) space, but still not the best solution.
//Could you devise a constant space solution?




public class SetMatrixZeroes {

    public static void main(String[] args) {
            int[][] a = {{0,1,1},{1,1,1},{1,1,1}};
            setZeroes(a);
    }

    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)    return;
        int m = matrix.length, n = matrix[0].length;
        boolean row = false, col = false;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    if(i == 0)
                        row = true;
                    else if(j == 0)
                        col = true;
                    else{
//                            store states of each row in the first of that row, and store states of each column in the first of that column
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        for(int i=m-1;i>=0;i--)
            for(int j=n-1;j>=0;j--)
                if(i == 0 && row == true || j == 0 && col == true || matrix[0][j] == 0 || matrix[i][0] == 0 )
                    matrix[i][j] = 0;
    }
    
//    GIPlan
    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)    return;
        int m = matrix.length, n=matrix[0].length;
        // 第一行第一列是否有0
        Boolean row = false , col = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i==0) row=true;
                    else if(j==0) col=true;
                    else{
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }
        }
//        0 0 0 5        0 0 0 5
//        4 3 1 4        4 3 1 4
//        0 1 1 4        0 1 1 4
//        1 2 1 3        1 2 1 3
//        0 0 1 1        0 0 1 1

// Important!!! Must iterate backward, since the first row can not be changed until the last
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][0]==0||matrix[0][j]==0||i==0&&row||j==0&&col){
                    matrix[i][j]=0;
                }
            }
        }
    }

}

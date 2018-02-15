package leetcode;

public class UniquePathsII {

    public static void main(String[] args) {
        Integer[][] map = new Integer[2][2];
        System.out.println(map[0][0]);
    }
     public int uniquePaths(int[][] obstacleGrid) {
        boolean flag = false;
//         map[i][j] means how many path can get point (i, j)
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            if(obstacleGrid[i][0]==1||flag==true){
                map[i][0] = 0;
                flag=true;
            } else map[i][0] = 1;
        }
        flag = false;
        for(int j= 0;j<n;j++){
            if(obstacleGrid[0][j]==1||flag==true){
                map[0][j]=0;
                flag=true;
            } 
            else map[0][j] = 1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j]!=1) map[i][j] = map[i-1][j]+map[i][j-1];
                else map[i][j]=0;
            }
        }
        return map[m-1][n-1];
    }

}

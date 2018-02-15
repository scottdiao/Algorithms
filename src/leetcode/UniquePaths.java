package leetcode;

public class UniquePaths {

    public static void main(String[] args) {
            // TODO Auto-generated method stub
    }
     public int uniquePaths(int m, int n) {
//         map[i][j] means how many path can get point (i, j)
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

}

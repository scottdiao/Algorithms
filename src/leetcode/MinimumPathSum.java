package leetcode;

public class MinimumPathSum {

	public static void main(String[] args) {
            int[][] a = {{1,3,1}};
            System.out.println(minPathSum(a));
	}
	
	public static int minPathSum(int[][] grid) {
            int m = grid.length;// row
            int n = grid[0].length; // column
            // 在矩阵中存到此点最小的sum
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j != 0) {
                        grid[i][j] = grid[i][j] + grid[i][j - 1];
                    } else if (i != 0 && j == 0) {
                        grid[i][j] = grid[i][j] + grid[i - 1][j];
                    } else if(i != 0 && j != 0){
                        grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])+ grid[i][j];
                    }
                }
            }

            return grid[m - 1][n - 1];
        }

}

package leetcode;

public class SpiralMatrixII {

    public static void main(String[] args) {

            System.out.println(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
	int left = 0,top = 0;
	int right = n -1,down = n - 1;
	int count = 1;
	while (left <= right) {
//            traverse right
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            top ++;
//            traverse down
            for (int i = top; i <= down; i ++) {
                    ret[i][right] = count ++;
            }
            right --;
//            traverse left
            for (int j = right; j >= left; j --) {
                    ret[down][j] = count ++;
            }
            down --;
//            traverse up
            for (int i = down; i >= top; i --) {
                    ret[i][left] = count ++;
            }
            left ++;
	}
	return ret;
    }
}

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int len = matrix.length;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i = 0; i < len; i++) {
            int left = 0;
            int right = len - 1;
            while(left < right) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }
    }
}

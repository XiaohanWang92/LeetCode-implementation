public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxLen = 0;
        int[][] dpSize = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            dpSize[i][0] = matrix[i][0] - '0';
            if(matrix[i][0] == '1') maxLen = 1;
        }
        for(int i = 1; i < matrix[0].length; i++) {
            dpSize[0][i] = matrix[0][i] - '0';
            if(matrix[0][i] == '1') maxLen = 1;
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                int tmp = matrix[i][j] - '0';
                if(tmp == 0){
                    dpSize[i][j] = 0;
                    continue;
                }
                dpSize[i][j] = Math.min(dpSize[i - 1][j - 1], Math.min(dpSize[i - 1][j], dpSize[i][j - 1])) + tmp;
                if(dpSize[i][j] > maxLen) maxLen = dpSize[i][j];
            }
        }
        return maxLen * maxLen;
    }
}

public class NumMatrix {
    private int[][] sumRange;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)  return;
        int row = matrix.length;
        int col = matrix[0].length;
        sumRange = new int[row + 1][col + 1];
        for(int i = 1; i < row + 1; i++) {
            for(int j = 1; j < col + 1; j++)
                sumRange[i][j] = sumRange[i][j - 1] + sumRange[i - 1][j] - sumRange[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRange[row2 + 1][col2 + 1] + sumRange[row1][col1] - sumRange[row2 + 1][col1] - sumRange[row1][col2 + 1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

public class Solution {
    public int totalNQueens(int n) {
        if(n <= 0)  return 0;
        boolean[] usedCol = new boolean[n];

        // n * n board will have 2 * n - 1 diagonals
        boolean[] usedDiag = new boolean[2 * n - 1];
        boolean[] usedAntidiag = new boolean[2 * n - 1];
        int[] result = new int[1];

        // add queen row by row
        dfs(result, 0, n, usedCol, usedDiag, usedAntidiag);
        return result[0];
    }
    
    private void dfs(int[] result, int row, int n, boolean[] usedCol,
                     boolean[] usedDiag, boolean[] usedAntidiag) {
        if (row == n) {
            result[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {

            // convert coordinate to diagonal
            if (usedCol[i] || usedDiag[row + i] || usedAntidiag[row - i + n - 1]) continue;
            usedCol[i] = true;
            usedDiag[row + i] = true;
            usedAntidiag[row - i + n - 1] = true;
            dfs(result, row + 1, n, usedCol, usedDiag, usedAntidiag);
            usedCol[i] = false;
            usedDiag[row + i] = false;
            usedAntidiag[row - i + n - 1] = false;
        }
    }
}

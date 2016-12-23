public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if(n <= 0)  return results;
        boolean[] usedCol = new boolean[n];

        // n * n board will have 2 * n - 1 diagonals
        boolean[] usedDiag = new boolean[2 * n - 1];
        boolean[] usedAntidiag = new boolean[2 * n - 1];

        // add queen row by row
        dfs(results, new ArrayList<String>(), 0, n, usedCol, usedDiag, usedAntidiag);
        return results;
    }

    private void dfs(List<List<String>> results, List<String> path, int row, int n, boolean[] usedCol,
                     boolean[] usedDiag, boolean[] usedAntidiag) {
        if (row == n) {
            results.add(new ArrayList<String>(path));
            return;
        }
        for (int i = 0; i < n; i++) {

            // convert coordinate to diagonal
            if (usedCol[i] || usedDiag[row + i] || usedAntidiag[row - i + n - 1]) continue;
            char[] rowCharArray = new char[n];
            Arrays.fill(rowCharArray, '.');
            rowCharArray[i] = 'Q';
            String rowString = new String(rowCharArray);
            path.add(rowString);
            usedCol[i] = true;
            usedDiag[row + i] = true;
            usedAntidiag[row - i + n - 1] = true;
            dfs(results, path, row + 1, n, usedCol, usedDiag, usedAntidiag);
            path.remove(path.size() - 1);
            usedCol[i] = false;
            usedDiag[row + i] = false;
            usedAntidiag[row - i + n - 1] = false;
        }
    }
}

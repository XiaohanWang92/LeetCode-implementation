public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int lives = countLives(board, m, n, i, j);
                if(board[i][j] == 0) {
                    if(lives == 3)
                        board[i][j] |= 2;
                } else {
                    if(lives <= 3 && lives >= 2)
                        board[i][j] |= 2;
                }
            }
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                board[i][j] >>= 1;
    }

    private int countLives(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        if(i != 0) {

            // up-left cell
            if(j != 0)
                lives += board[i - 1][j - 1] & 1;

            // up-mid cell
            lives += board[i - 1][j] & 1;

            // up-right cell
            if(j != n - 1)
                lives += board[i - 1][j + 1] & 1;
        }

        // left cell
        if(j != 0)
            lives += board[i][j - 1] & 1;

        // right cell
        if(j != n - 1)
            lives += board[i][j + 1] & 1;
        if(i != m - 1) {

            // down-left cell
            if(j != 0)
                lives += board[i + 1][j - 1] & 1;

            // down-mid cell
            lives += board[i + 1][j] & 1;

            // down-right cell
            if(j != n - 1)
                lives += board[i + 1][j + 1] & 1;
        }
        return lives;  
    }
}

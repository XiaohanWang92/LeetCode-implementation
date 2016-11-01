public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;

        // row and column
        for(int i = 0; i < 9; i++) {
            if(!isValidSudoku(board, i, i, 0, 8))
                return false;
            if(!isValidSudoku(board, 0, 8, i, i))
                return false;
        }

        // 3x3 square
        for(int ro = 0; ro <= 2; ro++) {
            for(int co = 0; co <= 2; co++)
                if(!isValidSudoku(board, ro * 3, ro * 3 + 2, co * 3, co * 3 + 2))
                    return false;
        }
        return true;
    }

    // row start->rs, row end->re, column start->cs, column end->ce
    private boolean isValidSudoku(char[][] board, int rs, int re, int cs, int ce) {
        Set<Character> set = new HashSet<Character>();
        for(int i = rs; i <= re; i++) {
            for(int j = cs; j <= ce; j++) {
                char c = board[i][j];
                if(c != '.' && !set.add(c))
                    return false;
            }
        }
        return true;
    }
}

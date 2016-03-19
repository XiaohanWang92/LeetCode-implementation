public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.equals(""))
            return false;
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(find(board, used, i, j, 0, word, m, n))
                    return true;
            }
        }
        return false;
    }
    private boolean find(char[][] board, boolean[][] used, int i, int j, int pos, String word, int m, int n){
        if(pos == word.length())
            return true;
        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if(word.charAt(pos) != board[i][j] || used[i][j])
            return false;
        else{
            used[i][j] = true;
            if(find(board, used, i+1, j, pos+1, word, m, n) || find(board, used, i-1, j, pos+1, word, m, n) ||
               find(board, used, i, j+1, pos+1, word, m, n) || find(board, used, i, j-1, pos+1, word, m, n))
                return true;
            used[i][j] = false;
            return false;
        }
    }
}

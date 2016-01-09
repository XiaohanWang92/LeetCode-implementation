public class Solution {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0||word==null||word.length()==0)
            return false;
        char[] wordChar = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(findWord(wordChar, board, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean findWord(char[] word, char[][] board, int row, int col, int wordNum){
        if(word.length==wordNum)    return true;
        if(row<0||row>board.length-1||col<0||col>board[row].length-1) return false;
        if(word[wordNum]!=board[row][col]||visited[row][col])  return false;
        
        visited[row][col] = true;
        if(findWord(word, board, row-1, col, wordNum+1)||
           findWord(word, board, row+1, col, wordNum+1)||
           findWord(word, board, row, col-1, wordNum+1)||
           findWord(word, board, row, col+1, wordNum+1)){
               return true;
           }
        visited[row][col] = false;
        return false;
    }
}

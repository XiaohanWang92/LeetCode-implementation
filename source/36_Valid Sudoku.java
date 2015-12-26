public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
         if (!isValid(board,i,i,0,8))
              return false;
         if (!isValid(board,0,8,i,i))
                return false;
        }
         for (int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               if (!isValid(board,i*3,i*3+2,j*3,j*3+2))
                   return false;
           }
        }
        return true;
    }
    private boolean isValid(char[][] board, int xs, int xe,int ys,int ye){
        HashSet<Character> hs = new HashSet<Character>();
        for (int i= xs; i<=xe; i++){
             for (int j=ys;j<=ye; j++){
                 if (board[i][j]!='.') {
                        if(!hs.add(board[i][j]))
                             return false;
                 }
            }
        }
         return true;
    }
}
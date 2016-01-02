public class Solution {
    public void solve(char[][] board) {
        if(board.length<=2||board[0].length<=2) return;
        int rowNum=board.length;
        int colNum=board[0].length;
        //left and right border
        for(int i=0;i<rowNum;i++){
            if(board[i][0]=='O')    markUnchange(board, i, 0);
            if(board[i][colNum-1]=='O') markUnchange(board, i, colNum-1);
        }
        //up and down border
        for(int i=0;i<colNum;i++){
            if(board[0][i]=='O')    markUnchange(board, 0 ,i);
            if(board[rowNum-1][i]=='O') markUnchange(board,rowNum-1,i);
        }
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(board[i][j]=='O')    board[i][j]='X';
                if(board[i][j]=='S')    board[i][j]='O';
            }
        }
    }
    private void markUnchange(char[][] board, int rowIdx, int colIdx){
        Stack<Integer> indexR = new Stack<>();
        Stack<Integer> indexC = new Stack<>();
        board[rowIdx][colIdx]='S';
        indexR.push(rowIdx);
        indexC.push(colIdx);
        while(!indexR.empty()){
            int r=indexR.pop();
            int c=indexC.pop();
            //above
            if(r!=0&&board[r-1][c]=='O'){
                indexR.push(r-1);
                indexC.push(c);
                board[r-1][c]='S';
            }
            //below
            if(r!=board.length-1&&board[r+1][c]=='O'){
                indexR.push(r+1);
                indexC.push(c);
                board[r+1][c]='S';
            }
            //left
            if(c!=0&&board[r][c-1]=='O'){
                indexR.push(r);
                indexC.push(c-1);
                board[r][c-1]='S';
            }
            //right
            if(c!=board[0].length-1&&board[r][c+1]=='O'){
                indexR.push(r);
                indexC.push(c+1);
                board[r][c+1]='S';
            }
        }
    }
}

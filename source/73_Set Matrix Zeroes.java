public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null)    return;
        int n = matrix.length, m = matrix[0].length, col0=1;
        for(int i=0; i<n; i++){
            //don't need to set matrix[i][0]=0 to indicate row1 will all be set to 0
            //because matrix[i][0] is zero already
            if(matrix[i][0]==0)
                col0 = 0;
            for(int j=1; j<m; j++)
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }
        //check row0 and col0 at last because they are used to store states of other lines
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(matrix[0][0]==0)
            for(int i=1; i<m; i++)
                matrix[0][i]=0;
        if(col0==0)
            for(int i=0; i<n; i++)
                matrix[i][0]=0;
    }
}
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null)    return;
        int n = matrix.length, m = matrix[0].length, col0 = 1;
        for(int i = 0; i < n; i++) {

            // Don't need to set matrix[i][0]=0, because matrix[i][0] is zero already
            if(matrix[i][0] == 0)
                col0 = 0;
            for(int j = 1; j < m; j++)
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }

        // Check row0 and col0 at last because they are used to store states of other lines
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(matrix[0][0] == 0)
            for(int i = 1; i < m; i++)
                matrix[0][i] = 0;
        if(col0 == 0)
            for(int i = 0; i < n; i++)
                matrix[i][0] = 0;
    }
}
//other code, more understandable
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length, n = matrix[0].length;
        int ro = 1, col = 1;
        if(matrix[0][0] == 0){
            ro = 0;
            col = 0;
        }
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0)
                col = 0;
        }
        for(int i = 1; i < n; i++){
            if(matrix[0][i] == 0)
                ro = 0;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++)
                    matrix[i][j] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < m; j++)
                    matrix[j][i] = 0;
            }
        }
        if(ro == 0){
            for(int i = 0; i < n; i++)
                matrix[0][i] = 0;
        }
        if(col == 0){
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
}


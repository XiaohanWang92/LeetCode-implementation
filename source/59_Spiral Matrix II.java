public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<=0)    return new int[0][0];
        int[][] matrix = new int[n][n];
        int count = n*n;
        int num = 1;
        int left = 0;
        int right = n-1;
        int up = 0;
        int down =n-1;
        while(true){
            for(int i=left; i<=right && num<=count; i++){
                matrix[up][i] = num;
                num++;
            }
            up++;
            for(int i=up; i<=down && num<=count; i++){
                matrix[i][right] = num;
                num++;
            }
            right--;
            for(int i=right; i>=left && num<=count; i--){
                matrix[down][i] = num;
                num++;
            }
            down--;
            for(int i=down; i>=up && num<=count; i--){
                matrix[i][left] = num;
                num++;
            }
            left++;
            if(num>count)   break;
        }
        return matrix;
    }
}

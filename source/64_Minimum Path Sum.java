public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)   return Integer.MAX_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        int[][] soFarMinPath = new int[n][m];
        soFarMinPath[0][0] = grid[0][0];
        for(int i=1; i<m; i++){
            soFarMinPath[0][i] = grid[0][i]+soFarMinPath[0][i-1];
        }
        for(int i=1; i<n; i++){
            soFarMinPath[i][0] = grid[i][0]+soFarMinPath[i-1][0];
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                soFarMinPath[i][j] = Math.min(soFarMinPath[i][j-1], soFarMinPath[i-1][j])+grid[i][j];
            }
        }
        return soFarMinPath[n-1][m-1];
    }
}

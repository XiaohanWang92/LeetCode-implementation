public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int number = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    explore(grid, i, j, m, n);
                    number++;
                }
            }
        }
        
        return number;
    }
    private void explore(char[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n)  return;
        if(grid[i][j]=='0') return;
        grid[i][j]='0';
        explore(grid, i+1, j, m, n);
        explore(grid, i-1, j, m, n);
        explore(grid, i, j+1, m, n);
        explore(grid, i, j-1, m, n);
    }
}

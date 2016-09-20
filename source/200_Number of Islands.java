public class Solution {
    
    private static final char WATER = '0';
    private static final char LAND = '1';
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int islandNum = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == LAND) {
                    islandNum++;
                    bfsIsland(i, j, grid);
                }
            }
        }
        return islandNum;
    }
    
    private void bfsIsland(int row, int col, char[][]grid) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if(grid[row][col] == WATER) {
            return;
        }
        grid[row][col] = WATER;
        bfsIsland(row - 1, col, grid);
        bfsIsland(row + 1, col, grid);
        bfsIsland(row, col + 1, grid);
        bfsIsland(row, col - 1, grid);
    }
}

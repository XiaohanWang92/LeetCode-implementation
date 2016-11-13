public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0].length == 0)
            return 0;
        int rowEnemyNum = 0;
        int[] colEnemyNum = new int[grid[0].length];
        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'W') continue;
                
                // we are in first row, need to calculate each column's enemy until meet a wall
                // we have a wall placed right above, need to recalculate current column's enemy
                if(i == 0 || grid[i - 1][j] == 'W') {
                    colEnemyNum[j] = countColEnemyUntilHitWall(grid, i, j);
                }
                
                // we are in first column, need to calculate new row's enemy until meet a wall
                // we have a wall placed just left, need to recalculate current row's enemy
                if(j == 0 || grid[i][j - 1] == 'W') {
                    rowEnemyNum = countRowEnemyUntilHitWall(grid, i, j);
                }
                if(grid[i][j] == '0') {
                    result = Math.max(result, rowEnemyNum + colEnemyNum[j]);
                }
            }
        }
        return result;
    }
    
    private int countColEnemyUntilHitWall(char[][] grid, int i, int j) {
        int count = 0;
        while(i < grid.length && grid[i][j] != 'W') {
            if(grid[i][j] == 'E')
                count++;
            i++;
        }
        return count;
    }
    
    private int countRowEnemyUntilHitWall(char[][] grid, int i, int j) {
        int count = 0;
        while(j < grid[0].length && grid[i][j] != 'W') {
            if(grid[i][j] == 'E')
                count++;
            j++;
        }
        return count;
    }
    
}

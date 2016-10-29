public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int m = grid.length, n = grid[0].length;

        // store each 0 to all reachable building's distance
        int[][] dist = new int[m][n];

        // store each 0's reachable buildings
        int[][] reachNum = new int[m][n];

        // 4 directions change for BFS
        int[] rowChange = {1, 0, -1, 0};
        int[] colChange = {0, 1, 0, -1};

        // store total building amount
        int buildingNum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                // if find a building, begin BFS
                if(grid[i][j] == 1) {
                    buildingNum++;

                    // level means current distance to the building which is under BFS
                    int level = 1;
                    Queue<int[]> q = new LinkedList<>();

                    // store points that have already been visited
                    boolean[][] visited = new boolean[m][n];
                    q.offer(new int[] {i, j});

                    // begin BFS
                    while(q.size() != 0) {
                        int size = q.size();

                        // one round for BFS
                        for(int iterate = 0; iterate < size; iterate++) {
                            int[] currentCoor = q.poll();

                            // check up down left right four directions
                            for(int k = 0; k < 4; k++) {
                                int nextRow = currentCoor[0] + rowChange[k];
                                int nextCol = currentCoor[1] + colChange[k];

                                // if meet a valid 0 point, update this point's distance/reached building/visited and add it into queue
                                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n &&
                                   grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                                       reachNum[nextRow][nextCol]++;
                                       dist[nextRow][nextCol] += level;
                                       visited[nextRow][nextCol] = true;
                                       q.offer(new int[] {nextRow, nextCol});
                                   }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && reachNum[i][j] == buildingNum) {
                    result = Math.min(dist[i][j], result);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

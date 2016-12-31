public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null) return;
        if(rooms.length == 0 || rooms[0].length == 0)   return;
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0)
                    BFS(rooms, i, j, 0);
            }
        }
    }
    private void BFS(int[][] rooms, int i, int j, int dist) {
        if(i < 0 || i > rooms.length - 1)   return;
        if(j < 0 || j > rooms[0].length - 1)    return;
        if(rooms[i][j] < dist)    return;
        rooms[i][j] = dist;
        BFS(rooms, i - 1, j, dist + 1);
        BFS(rooms, i, j - 1, dist + 1);
        BFS(rooms, i + 1, j, dist + 1);
        BFS(rooms, i, j + 1, dist + 1);
    }
}

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)  return;
        int rowNum = rooms.length, colNum = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                if(rooms[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }
        while(!queue.isEmpty()) {
            int[] coordinate = queue.remove();
            int row = coordinate[0], col = coordinate[1];
            if(row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if(row < rowNum - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if(col < colNum - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}

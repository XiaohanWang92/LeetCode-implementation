public class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)  return new ArrayList<int[]>();
        int row = matrix.length, col = matrix[0].length;
        Queue<int[]> pacificQ = new LinkedList<>(), atlanticQ = new LinkedList<>();
        boolean[][] pacificVisit = new boolean[row][col], atlanticVisit = new boolean[row][col];
        List<int[]> results = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            pacificQ.offer(new int[] {i, 0});
            pacificVisit[i][0] = true;
            atlanticQ.offer(new int[] {i, col - 1});
            atlanticVisit[i][col - 1] = true;
        }

        // it is OK to add some redundant cells
        for(int i = 0; i < col; i++) {
            pacificQ.offer(new int[] {0, i});
            pacificVisit[0][i] = true;
            atlanticQ.offer(new int[] {row - 1, i});
            atlanticVisit[row - 1][i] = true;
        }
        waterFlowBFS(pacificQ, pacificVisit, matrix, row, col);
        waterFlowBFS(atlanticQ, atlanticVisit, matrix, row, col);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(pacificVisit[i][j] && atlanticVisit[i][j]) {
                    results.add(new int[] {i, j});
                }
            }
        }
        return results;
    }
    
    private void waterFlowBFS(Queue<int[]> oceanQ, boolean[][] visitBoard, int[][] matrix, int row, int col) {
        while(oceanQ.size() != 0) {
            int[] water = oceanQ.poll();
            for(int[] direction : directions) {
                int[] neignborWater = {water[0] + direction[0], water[1] + direction[1]};
                if(neignborWater[0] < 0 || neignborWater[0] >= row ||
                   neignborWater[1] < 0 || neignborWater[1] >= col ||
                   visitBoard[neignborWater[0]][neignborWater[1]] ||
                   matrix[water[0]][water[1]] > matrix[neignborWater[0]][neignborWater[1]]) {
                    continue;
                }
                oceanQ.offer(neignborWater);
                visitBoard[neignborWater[0]][neignborWater[1]] = true;
            }
        }
    }
}

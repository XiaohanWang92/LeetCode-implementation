public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Integer> results = new ArrayList<>();
        if(m <= 0 || n <= 0)    return results;
        int count = 0;

        // each cell has a parent
        int[] roots = new int[m * n];

        // -1 means it is water
        Arrays.fill(roots, -1);
        for(int[] position : positions) {

            // flatten 2D coordinate
            int currentRootId = position[0] * n + position[1];
            roots[currentRootId] = currentRootId;
            count += 1;
            for(int[] direction : directions) {
                int nextRow = position[0] + direction[0];
                int nextCol = position[1] + direction[1];
                if(nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n || roots[nextRow * n + nextCol] == -1)
                    continue;
                int neignborRootId = find(roots, nextRow * n + nextCol);
                if(neignborRootId != currentRootId) {

                    // union
                    roots[currentRootId] = neignborRootId;
                    currentRootId = neignborRootId;
                    count -= 1;
                }
            }
            results.add(count);
        }
        return results;
    }
    
    private int find(int[] roots, int rootId){
        while(roots[rootId] != rootId) {

            // path compression
            roots[rootId] = roots[roots[rootId]];
            rootId = roots[rootId];
        }
        return rootId;
    }
}

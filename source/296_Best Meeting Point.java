public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xAxis = new ArrayList<>();
        List<Integer> yAxis = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    xAxis.add(j);
                    yAxis.add(i);
                }
            }
        }
        return getDistanceOfMedian(xAxis) + getDistanceOfMedian(yAxis); 
    }
    
    // calculate all point distances with the median
    private int getDistanceOfMedian(List<Integer> coordinate) {
        Collections.sort(coordinate);
        int i = 0, j = coordinate.size() - 1, distance = 0;
        while(i < j) {
            distance += coordinate.get(j) - coordinate.get(i);
            j--;
            i++;
        }
        return distance;
    }
}

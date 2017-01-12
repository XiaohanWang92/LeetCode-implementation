public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null)
            return false;
        if(points.length <= 1)
            return true;
        Set<String> pointSet = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int[] point : points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            pointSet.add(point[0] + ", " + point[1]);
        }
        int range = min + max;
        for(int[] point : points) {
            if(!pointSet.contains((range - point[0]) + ", " + point[1]))
                return false;
        }
        return true;
    }
}

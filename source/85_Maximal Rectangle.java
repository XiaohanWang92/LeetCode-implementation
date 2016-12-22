public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        
        // compute row by row
        // left[i] indicates on current row at column i,
        // if current position is a '1', left[i] is the left boundary of the consecutive '1'
        // if current position is a '0', then left[i] = -1, means there is no rectangle here
        // right, height arrays have the same rationale
        int[] left = new int[m], right = new int[m], height = new int[m];
        Arrays.fill(left, -1);
        Arrays.fill(right, m);
        Arrays.fill(height, -1);
        int maxRectangle = 0;
        for(int i = 0; i < n; i++) {
            int leftBoundary = 0, rightBoundary = m - 1;
            for(int j = 0; j < m; j++) {
                
                // update heigth
                if(matrix[i][j] == '1') {
                    if(height[j] == -1) height[j] = 1;
                    else    height[j] += 1;
                } else {
                    height[j] = -1;
                }
                
                // update leftBoundary
                if(matrix[i][j] == '1') {
                    
                    // need to compare previous row's leftBoundary (left[j]) to form a valid rectangle
                    left[j] = Math.max(left[j], leftBoundary);
                } else {
                    left[j] = -1;
                    
                    // only updates when encountering '0' so consecutive '1' can be memorized by boundary
                    leftBoundary = j + 1;
                }
            }
            for(int j = m - 1; j >= 0; j--) {
                // update rightBoundary
                if(matrix[i][j] == '1') {
                    
                    // need to compare previous row's rightBoundary (right[j]) to form a valid rectangle
                    right[j] = Math.min(right[j], rightBoundary);
                } else {
                    right[j] = m;
                    
                    // only updates when encountering '0' so consecutive '1' can be memorized by boundary
                    rightBoundary = j - 1;
                }
            }
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    maxRectangle = Math.max(maxRectangle, (right[j] - left[j] + 1) * height[j]);
                }
            }
        }
        return maxRectangle;
    }
}

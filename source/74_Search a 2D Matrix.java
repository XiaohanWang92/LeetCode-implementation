public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int ro = mid / n;
            int col = mid - ro * n;
            if(matrix[ro][col] == target) {
                return true;
            } else if(matrix[ro][col] < target) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return false;
    }
}

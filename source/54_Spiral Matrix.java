public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return res;
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        
        while(true){
            for(int i=left; i<=right; i++){
                res.add(matrix[up][i]);
            }
            up++;
            
            if(isDone(up, down, left, right))
                break;
                
            for(int i=up; i<=down; i++){
                res.add(matrix[i][right]);
            }
            right--;
            
            if(isDone(up, down, left, right))
                break;
                
            for(int i=right; i>=left; i--){
                res.add(matrix[down][i]);
            }
            down--;
            
            if(isDone(up, down, left, right))
                break;
                
            for(int i=down; i>=up; i--){
                res.add(matrix[i][left]);
            }
            left++;
            
            if(isDone(up, down, left, right))
                break;
        }
        
        return res;
    }
    private boolean isDone(int up, int down, int left, int right){
        if(up>down||left>right) return true;
        return false;
    }
}

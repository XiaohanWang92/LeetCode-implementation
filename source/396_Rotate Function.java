public class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0, len = A.length, fValue = 0;
        int max = 0;
        for(int i = 0; i < len; i++) {
            sum += A[i];
            
            // Get F(0)
            fValue += i * A[i];
            max = fValue;
        }
        
        // F(k) = F(k - 1) + sum - nBk[0] = F(k - 1) + sum - len * A[len - k]
        for(int i = 1; i < len; i++) {
            fValue = fValue + sum - len * A[len - i];
            max = Math.max(max, fValue);
        }
        return max;
    }
}

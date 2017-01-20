public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null)    return null;
        int len = nums.length;
        int[] results = new int[len];
        if(len == 0)    return results;
        if(len == 1) {
            results[0] = nums[0];
            return results;
        }
        if(a == 0) {
            if(b >= 0) {
                for(int i = 0; i < len; i++) {
                    results[i] = b * nums[i] + c;
                }
                return results;
            } else {
                for(int i = len - 1; i >= 0; i--) {
                    results[len - 1 - i] = b * nums[i] + c;
                }
                return results;
            }
        }
        int i = 0, j = len - 1;
        if(a > 0) {
            int index = len - 1;
            while(i <= j) {
                results[index--] = calculateQuadraticResult(a, b, c, nums[i]) > calculateQuadraticResult(a, b, c, nums[j]) ? calculateQuadraticResult(a, b, c, nums[i++]) : calculateQuadraticResult(a, b, c, nums[j--]);
            }
        } else {
            int index = 0;
            while(i <= j) {
                results[index++] = calculateQuadraticResult(a, b, c, nums[i]) < calculateQuadraticResult(a, b, c, nums[j]) ? calculateQuadraticResult(a, b, c, nums[i++]) : calculateQuadraticResult(a, b, c, nums[j--]);
            }
        }
        return results;
    }
    
    private int calculateQuadraticResult(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}

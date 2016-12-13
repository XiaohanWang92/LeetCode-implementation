public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return dpHelper(dp, 1, n);
    }
    
    private int dpHelper(int[][] dp, int start, int end) {
        if(start >= end)    return 0;
        if(dp[start][end] != 0) return dp[start][end];
        int result = Integer.MAX_VALUE;
        for(int choose = start; choose <= end; choose++) {
            int cost = choose + Math.max(dpHelper(dp, start, choose - 1), dpHelper(dp, choose + 1, end));
            result = Math.min(cost, result);
        }
        dp[start][end] = result;
        return result;
    }
}

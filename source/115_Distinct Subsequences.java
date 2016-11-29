public class Solution {
    public int numDistinct(String s, String t) {
        if((s == null && s == null) || s.length() < t.length() || (s.length() == t.length() && !s.equals(t)))
            return 0;
        
        // empty string's distinct subsequence amount is always 0, so no need to make a (n + 1) * (m + 1) dp board
        int m = s.length(), n = t.length();
        
        // dp[i][j] means number of distinct susequences in s.substring(0, j + 1) for t.substring(0, i + 1) 
        int[][] dp = new int[n][m];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if(sc[0] == tc[0])  dp[0][0] = 1;
        for(int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1];
            if(sc[i] == tc[0])  dp[0][i] += 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(sc[j] == tc[i]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}

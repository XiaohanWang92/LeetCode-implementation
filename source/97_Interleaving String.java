public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)  return false;
        if(s1.length() + s2.length() != s3.length())  return false;
        
        
        // dp[i][j] means
        // whether s1 first i chars(0 to (i - 1)) and s2 first j chars(0 to (j - 1)) are interleaving
        // i = 0 or j = 0 means s1 or s2 is empty
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < s1.length() + 1; i++) {
            for(int j = 0; j < s2.length() + 1; j++) {
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                else if(i == 0) {
                    
                    // notice zero base, j means first s2 j chars are interleaving with empty string(s1)
                    // so it is char with index of 0 to (j - 1)
                    if(dp[0][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = true;
                    }
                } else if(j == 0) {
                    if(dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1)) {
                        dp[i][j] = true;
                    }
                } else {
                    if(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        dp[i][j] = true;
                    if(dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

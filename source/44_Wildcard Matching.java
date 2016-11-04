public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)  return false;
        int pLength = p.length(), sLength = s.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for(int i = 1; i < pLength + 1; i++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for(int i = 1; i < sLength + 1; i++) {
            for(int j = 1; j < pLength + 1; j++) {
                if(p.charAt(j - 1) != '*') {
                    if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    
                    // check if match a empty string (dp[i][j - 1]) or match previous string (dp[i - 1][j])
                    if(dp[i][j - 1] || dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }
}

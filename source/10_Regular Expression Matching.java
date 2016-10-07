public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int j = 1; j < match[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (match[0][j - 1] || (j > 1 && match[0][j - 2])) {
                    match[0][j] = true;
                }
            } 
        }
        for (int i = 1; i < match.length; i++) {
            for (int j = 1; j < match[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    match[i][j] = match[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        match[i][j] = match[i][j - 2];
                    } else {
                        match[i][j] = match[i - 1][j] || match[i][j - 1] || match[i][j - 2];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}

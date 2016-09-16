public class Solution {
    public int numberOfPatterns(int m, int n) {
        if(m == n && m == 1) return 9;
        
        // Marks the skip number between two number
        // 1-8, 4-7, cases with no skip number like these are allowed
        int[][] skipNumber = new int[10][10];
        skipNumber[1][3] = skipNumber[3][1] = 2;
        skipNumber[1][7] = skipNumber[7][1] = 4;
        skipNumber[3][9] = skipNumber[9][3] = 6;
        skipNumber[7][9] = skipNumber[9][7] = 8;
        skipNumber[1][9] = skipNumber[9][1] = 5;
        skipNumber[3][7] = skipNumber[7][3] = 5;
        skipNumber[4][6] = skipNumber[6][4] = 5;
        skipNumber[2][8] = skipNumber[8][2] = 5;
        boolean[] visited = new boolean[10];
        int result = 0;
        for(int i = m; i <= n; i++) {
            result += searchValidUnlockPattern(skipNumber, visited, 1, i - 1) * 4;
            result += searchValidUnlockPattern(skipNumber, visited, 2, i - 1) * 4;
            result += searchValidUnlockPattern(skipNumber, visited, 5, i - 1);
        }
        return result;
    }
    
    private int searchValidUnlockPattern(int[][] skipNumber, boolean[] visited, int currentNum, int remainStep) {
        if(remainStep < 0)  return 0;
        if(remainStep == 0)  return 1;
        int result = 0;
        visited[currentNum] = true;
        for(int nextNum = 1; nextNum <= 9; nextNum++) {
            if(!visited[nextNum] && ( skipNumber[currentNum][nextNum] == 0 || visited[skipNumber[currentNum][nextNum]] )) {
                result += searchValidUnlockPattern(skipNumber, visited, nextNum, remainStep - 1);
            }
        }
        visited[currentNum] = false;
        return result;
    }
}

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)  return 1;
        if(n == 1)  return 10;
        if(n > 10)  return countNumbersWithUniqueDigits(10);
        int max = (int)Math.pow(10, n);
        boolean[] isUsed = new boolean[10];
        int count = dfsCounting(0, 0, max, isUsed);
        return count;
    }
    
    private int dfsCounting(int previousReachedNumber, int level, int max, boolean[] isUsed) {
        if(previousReachedNumber >= max) {
            return 0;
        }
        int count = 1;
        for(int i = 0; i <= 9; i++) {
            
            // Numbers such as 0213 is invalid, level 0 (highest digit cannot allow leading zero)
            if(level == 0 && i == 0) {
                continue;
            }
            
            // In java, new boolean is default to be false
            if(!isUsed[i]) {
                isUsed[i] = true;
                int currentReachedNumber = previousReachedNumber * 10 + i;
                count += dfsCounting(currentReachedNumber, level + 1, max, isUsed);
                isUsed[i] = false;
            }
        }
        return count;
    }
}

public static int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
        return 1;
    }
    int result = 10, base = 9;
    for (int i = 2; i <= n && i <= 10; i++) {
        base = base * (9 - i + 2);
        result += base;
    }
    return result;
}

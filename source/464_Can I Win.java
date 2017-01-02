public class Solution {
    int[] used;
    Map<String, Boolean> winMap = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= 0)   return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(sum < desiredTotal)  return false;
        used = new int[maxChoosableInteger + 1];
        return canWin(desiredTotal);
    }
    
    private boolean canWin(int desiredTotal) {
        
        // if desiredTotal has decreased to zero or less, which means in previous turn, rival has won
        // convert boolean array to string takes much more time than convert int array (boolean array causes TLE here)
        if(desiredTotal <= 0)   return false;
        String key = Arrays.toString(used);
        if(winMap.containsKey(key)) return winMap.get(key);
        for(int i = 1; i < used.length; i++) {
            if(used[i] == 0) {
                used[i] = 1;
                if(i > desiredTotal || !canWin(desiredTotal - i)) {
                    winMap.put(key, true);
                    used[i] = 0;
                    return true;
                }
                used[i] = 0;
            }
        }
        winMap.put(key, false);
        return false;
     }
}

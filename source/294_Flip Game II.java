public class Solution {

    public boolean canWin(String s) {
        if(s.length() < 2)    return false;
        Map<String, Boolean> winMap = new HashMap<>();
        return canWin(s, winMap);
    }

    private boolean canWin(String s, Map<String, Boolean> winMap) {
        if(winMap.containsKey(s))   return winMap.get(s);
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String rival = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!canWin(rival, winMap)) {
                    winMap.put(s, true);
                    return true;
                }
            }
        }
        winMap.put(s, false);
        return false;
    }
}

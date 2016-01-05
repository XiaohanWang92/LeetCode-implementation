public class Solution {
    public boolean canWin(String s) {
        if(s.length()<2)    return false;
        Map<String, Boolean> winmap = new HashMap<>();
        return canWin(s, winmap);
    }
    private boolean canWin(String s, Map<String, Boolean> winmap){
        if(winmap.containsKey(s))   return winmap.get(s);
        
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='+'&&s.charAt(i+1)=='+'){
                String rival = s.substring(0,i)+"--"+s.substring(i+2);
                if(!canWin(rival, winmap)){
                    winmap.put(s, true);
                    return true;
                }
            }
        }
        winmap.put(s, false);
        return false;
    }
}


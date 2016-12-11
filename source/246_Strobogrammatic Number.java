public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null)   return false;
        if(num.equals(""))  return true;
        HashMap<Character,Character> strobogrammaticMap = new HashMap<>();
        strobogrammaticMap.put('1','1');
        strobogrammaticMap.put('0','0');
        strobogrammaticMap.put('6','9');
        strobogrammaticMap.put('9','6');
        strobogrammaticMap.put('8','8');
        int length = num.length();
        for(int i = 0, j = length - 1; i <= j; i++,j--) {
            if(!strobogrammaticMap.containsKey(num.charAt(i)))
                return false;
            if(strobogrammaticMap.get(num.charAt(i)) != num.charAt(j))
                return false;
        }
        return true;
    }
}

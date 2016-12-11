public class Solution {
    
    private int result = 0;
    
    public int strobogrammaticInRange(String low, String high) {
        char[][] strobogrammaticPair = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        for(int len = low.length(); len <= high.length(); len++) {
            char[] strobogrammaticChar = new char[len];
            buildStrobogrammaticNumber(strobogrammaticChar, 0, len - 1, strobogrammaticPair, low, high);
        }
        return result;
    }
    
    private void buildStrobogrammaticNumber(char[] strobogrammaticChar, int left, int right, char[][] strobogrammaticPair, String low, String high) {
        if(left > right) {
            String number = new String(strobogrammaticChar);
            if((number.length() == low.length() && number.compareTo(low) < 0) ||
               (number.length() == high.length() && number.compareTo(high) > 0)) {
                   return;
            }
            result++;
            return;
        }
        for(char[] eachPair : strobogrammaticPair) {
            strobogrammaticChar[left] = eachPair[0];
            strobogrammaticChar[right] = eachPair[1];
            if((strobogrammaticChar.length != 1 && strobogrammaticChar[0] == '0') ||
               (left == right && eachPair[0] != eachPair[1])) {
                continue;
            }
            buildStrobogrammaticNumber(strobogrammaticChar, left + 1, right - 1, strobogrammaticPair, low, high);
        }
    }
}

public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.equals(""))   return 0;
        int len = s.length();
        int result = 0;
        for(int i = 0; i < len; i++) {
            result = result * 26 + (int)(s.charAt(i) - 'A' + 1);
            // do it from backward will make thing much more complicated
        }
        return result;
    }
}

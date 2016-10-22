public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0)    return false;
        s = s.trim();
        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasNumber = false;
        boolean hasNumberAfterE = false;
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] >= '0' && c[i] <= '9') {
                hasNumber = true;
            } else if (c[i] == '.') {
                if(hasE || hasPoint)
                    return false;
                hasPoint = true;
            } else if (c[i] == 'e') {
                if(hasE || !hasNumber) {
                    return false;
                }
                hasE = true;
                
                // Reset number to validate string showed after "e"
                hasNumber = false;
            } else if(c[i] == '-' || c[i] == '+') {
                if(i != 0 && c[i - 1] != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return hasNumber;
    }
}

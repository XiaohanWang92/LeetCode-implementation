public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        String s = str.trim();
        int idx = 0;
        boolean sign = true;
        if(s.charAt(idx) == '-' || s.charAt(idx) == '+'){
            sign = s.charAt(idx) == '-' ? false : true;
            idx++;
        }
        int res = 0;
        while(idx != s.length()){
            //Character.getNumericValue(char ch) can also work
            int digit = s.charAt(idx) - '0';
            //Character.isDigit()
            if(digit > 9 || digit < 0)
                break;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit))
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + digit;
            idx++;
        }
        return sign ? res : -res;
    }
}
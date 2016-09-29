public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        String s = str.trim();
        int index = 0;
        boolean sign = true;
        if(s.charAt(index) == '-' || s.charAt(index) == '+') {
            sign = s.charAt(index) == '-' ? false : true;
            index++;
        }
        int result = 0;

        while(index != s.length()) {

            // Character.getNumericValue(char ch) can also work
            int digit = s.charAt(index) - '0';

            // Character.isDigit()
            if(digit > 9 || digit < 0)
                break;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit))
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + digit;
            index++;
        }
        return sign ? result : -result;
    }
}
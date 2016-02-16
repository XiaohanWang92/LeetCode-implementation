public class Solution {
    public int myAtoi(String str) {
        //empty string
        if(str == null || str.length()==0)
            return 0;
        //whitespaces
        String s = str.trim();
        int idx = 0, sign = 1;
        //sign handle
        if(s.charAt(idx) == '+' || s.charAt(idx) == '-'){
            sign = s.charAt(idx) == '+'? 1 : -1;
            idx++;
        }
        //convert and check overflow
        int res = 0;
        while(idx < s.length()){
            int digit = s.charAt(idx) - '0';
            //valid character from '0' to '9'?
            //Character.getNumericValue(char ch) can also work
            if(digit < 0 || digit > 9)
                break;
            if(Integer.MAX_VALUE/10 < res ||
              (Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE%10 < digit)){
                  return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            idx++;
        }
        return res * sign;
    }
}

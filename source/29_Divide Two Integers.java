public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)    return Integer.MAX_VALUE;
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = -1;
        //directly abs(int) may cause overflow: -2^31 -> +2^31 -> -2^31
        long divd = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        if(divd < divs || divd == 0)  return 0;
        long res = divide(divd, divs);
        //Integer.MIN_VALUE / -1 = 2^31 -> overflow
        //Integer.MIN_VALUE / 1 = -2^31 -> be considered overflow as well, but will return right value because sign = -1
        if(res > Integer.MAX_VALUE){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(sign * res);
    }
    private long divide(long divd, long divs){
        if(divs > divd)
            return 0;
        long mul = 1;
        long tmp = divs;
        while((tmp + tmp) <= divd){
            mul += mul;
            tmp += tmp;
        }
        //18/3 first round tmp = 12, mul = 4, return 4 + divide(6, 3)
        return mul + divide(divd - tmp, divs);
    }
}

public class Solution {
    public int countDigitOne(int n) {
        if(n < 1) return 0;
        int q = n;
        int digit = 1;
        int result = 0;
        while(q > 0) {
            int currDecimal = q % 10;
            q /= 10;
            result += q * digit;
            if(currDecimal == 1)  result += n % digit + 1;
            if(currDecimal > 1)   result += digit;
            digit *= 10;
        }
        return result;
    }
}

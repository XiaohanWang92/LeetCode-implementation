public class Solution {
    public int countDigitOne(int n) {
        if(n<1) return 0;
        int q = n;
        int digit =1;
        int res = 0;
        while(q>0){
            int currDecimal = q % 10;
            q /= 10;
            res += q * digit;
            if(currDecimal == 1)  res += n % digit +1;
            if(currDecimal > 1)   res += digit;
            digit *= 10;
        }
        return res;
    }
}

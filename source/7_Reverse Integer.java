public class Solution {
    public int reverse(int x) {
        if(x == 0)
            return x;
        boolean sign = true;
        if(x < 0) {
            sign = false;
            x = Math.abs(x);
        }
        int check = 0;
        int digit = 0;
        int result = 0;
        while(x != 0) {
            digit = x % 10;
            result = 10 * result + digit;
            if(check != result / 10)
                return 0;
            check = result;
            x /= 10;
        }
        return sign == true ? result : -result;
    }
}

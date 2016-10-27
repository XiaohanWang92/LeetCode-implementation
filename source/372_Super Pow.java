public class Solution {
    private static final int MOD = 1337;
    
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }
    
    // 23^1335 % base
    // = ((23 ^ 133 % base) ^ 10) % base(23 ^ 5 % base) % base
    // = function(function(23, 133), 10) * function(23, 5) % base
    private int superPow(int a, int[] b, int lastDigitIndex) {
        if(lastDigitIndex == -1)    return 1;
        int highDigitResult = modPower(superPow(a, b, lastDigitIndex - 1), 10);
        int lastDigitResult = modPower(a, b[lastDigitIndex]);
        return (highDigitResult * lastDigitResult) % MOD;
    }
    
    private int modPower(int base, int exponent) {
        base = base % MOD;
        int result = 1;
        for(int i = 1; i <= exponent; i++) {
            
            // (aaa)%k=(a%k)(a%k)(a%k)%k
            result = (result * base) % MOD;
        }
        return result;
    }
}

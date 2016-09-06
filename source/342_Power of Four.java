public class Solution {
    public boolean isPowerOfFour(int num) {

        // Power of four is a positive number
        if(num <= 0)
            return false;

        // Binary of power of four only has one bit as '1'
        if((num & (num - 1)) != 0)
            return false;

        // 1 appears in odd bit, we use 0101 0101 ... to check this property
        if((num & 0x55555555) == 0)
            return false;
        return true;
    }
}
// Another solution
public boolean isPowerOfFour(int num) {
    return Integer.toString(num, 4).matches("10*");
}

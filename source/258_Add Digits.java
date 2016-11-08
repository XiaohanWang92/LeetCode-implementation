public class Solution {
    public int addDigits(int num) {
        int multi = (num - 1) / 9;
        return num - 9 * multi;
    }
}

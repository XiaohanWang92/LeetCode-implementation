public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        int setBit = xor & (-xor);
        for(int num : nums) {
            if((num&setBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}

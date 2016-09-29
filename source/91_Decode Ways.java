public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')//first is zero then no way to decode it
            return 0;
        int[] waysToDecode = new int[s.length()+1];
        waysToDecode[0] = 1;
        waysToDecode[1] = 1;
        for(int i = 2; i < s.length() + 1; i++) {
            int ways2 = 0, ways1 = 0;
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if(twoDigits >= 10 && twoDigits <= 26) {
                ways2 = waysToDecode[i - 2];
            }
            if(s.charAt(i - 1) != '0') {
                ways1 = waysToDecode[i - 1];
            }
            waysToDecode[i] = ways1 + ways2;
        }
        return waysToDecode[s.length()];
    }
}

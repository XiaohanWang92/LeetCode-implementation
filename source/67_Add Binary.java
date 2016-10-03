public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        StringBuffer sbf = new StringBuffer();
        int ida = charA.length - 1, idb = charB.length - 1;
        int addition = 0, bit = 0;
        while(ida >- 1 || idb >- 1 || addition == 1) {
            int bitA = (ida >- 1) ? Character.getNumericValue(charA[ida--]) : 0;
            int bitB = (idb >- 1)? Character.getNumericValue(charB[idb--]) : 0;
            bit = (bitA + bitB + addition) % 2;
            addition = (bitA + bitB + addition) >= 2 ? 1 : 0;
            sbf.insert(0, bit);
        }
        return sbf.toString();
    }
}
//faster, almost same idea
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int idx = 0, aLen = a.length(), bLen = b.length();
        int len = Math.max(aLen, bLen) - 1;
        while(idx <= len) {
            int res = carry + (idx < a.length() ? a.charAt(aLen - 1 - idx)-'0' : 0) 
                            + (idx < b.length() ? b.charAt(bLen - 1 - idx)-'0' : 0);
            carry = res/2;
            res %= 2;
            sb.append(res);
            idx++;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}


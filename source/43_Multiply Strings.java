public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] digit = new int[m + n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                digit[i + j + 1] += n1 * n2;
            }
        }
        int carry = 0;
        for(int i = m + n - 1; i >= 0; i--) {

            // New carry
            int nextCarry = (digit[i] + carry) / 10;

            // New digit
            digit[i] = (digit[i] + carry) % 10;
            carry = nextCarry;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : digit)  sb.append(i);
        while(sb.length() != 0 && sb.charAt(0) == '0')    sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

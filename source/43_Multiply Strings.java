public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] digitProducts = new int[len1+len2];
        for(int i=len1-1; i>=0; i--){
            for(int j=len2-1; j>=0; j--){
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';
                digitProducts[i+j+1] += a*b;
            }
        }
        int carry = 0;
        for(int i =len1+len2-1; i>=0; i--){
            int tmp = (digitProducts[i]+carry) % 10;
            carry = (digitProducts[i]+carry) / 10;
            digitProducts[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(int t :digitProducts)   sb.append(t);
        while(sb.length()!=0&&sb.charAt(0)=='0')    sb.deleteCharAt(0);
        return sb.length()==0?"0":sb.toString();
    }
}

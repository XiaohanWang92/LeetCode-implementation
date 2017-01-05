public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0)    return digits;
        int count = digits.length;
        if(digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            digits[digits.length - 1] = 0;
            count--;
            int next = digits.length - 2;
            while(next >= 0 && digits[next] == 9) { // next(>=0 condition) must reach the most significant digit!
                digits[next] = 0;
                next--;
                count--;
            }
            if(count == 0) {
                int[] newD = new int[digits.length + 1];
                newD[0] = 1;
                return newD;
            }
            digits[next]++;
            return digits;
        }
    }
}
//another implementation
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            int[] res = new int[1];
            res[0] = 1;
            return res;
        }
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] != 9)
                break;
            if(i == 0){
                int[] res = new int[digits.length+1];
                res[0] = 1;
                return res;
            }
        }
        int[] res = new int[digits.length];
        res[res.length-1] = digits[digits.length-1] + 1;
        int carry = res[res.length-1]/10;
        res[res.length-1] %= 10;
        for(int i = digits.length-2; i >= 0; i--){
            res[i] = carry + digits[i];
            carry = res[i]/10;
            res[i] %= 10;
        }
        return res;
    }
}

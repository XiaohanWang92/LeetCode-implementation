public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() <= 1)
            return s;
        char[] c = s.toCharArray();
        int low = 0, high = c.length - 1;
        while(high - low > 0) {
            char temp = c[low];
            c[low] = c[high];
            c[high] = temp;
            low++;
            high--;
        }
        return String.valueOf(c);
    }
}

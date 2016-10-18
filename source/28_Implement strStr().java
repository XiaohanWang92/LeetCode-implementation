public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() < needle.length())
            return -1;
        if(needle == null || needle.length() == 0)
            return 0;
        int len = needle.length();
        for(int i = 0; i <= haystack.length() - len; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(haystack.substring(i, i + len).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}

// charAt approach
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length())
            return false;
        if(s.length() == 0)
            return true;
        int sIndex = 0;
        for(int tIndex = 0; tIndex < t.length(); tIndex++) {
            if(s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            if(sIndex == s.length())
                return true;
        }
        return false;
    }
}

// indexOf approach
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length())
            return false;
        if(s.length() == 0)
            return true;
        int tIndex = t.indexOf(s.charAt(0));
        if(tIndex == -1)    return false;
        for(int sIndex = 1; sIndex < s.length(); sIndex++) {
            tIndex = t.indexOf(s.charAt(sIndex), tIndex + 1);
            if(tIndex == -1)    return false;
        }
        return true;
    }
}

// @Ankai.Liang in LeetCode
// I checked the origin code of func "indexOf" and "charAt".
// These two solution both traversed the char of String one by
// one to search the first occurrence specific char.
// The difference is that indexOf only call once function then
// traversed in "String.value[]" arr, but we used multiple calling
// function "charAt" to get the value in "String.value[]" arr.
// The time expense of calling function made the difference.
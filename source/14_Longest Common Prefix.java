public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        Arrays.sort(strs);
        int idx = 0;
        while(idx < strs[0].length() && idx < strs[strs.length - 1].length() &&
              strs[0].charAt(idx) == strs[strs.length - 1].charAt(idx))
            idx++;
        return strs[0].substring(0, idx);
    }
}

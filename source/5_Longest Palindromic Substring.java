public class Solution {
    private int startPos;
    private int maxLen;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)   return "";
        if(s.length()<2)    return s;
        for(int i = 0; i<s.length(); i++){
            findMaxPalin(i, i, s);//find odd
            findMaxPalin(i, i+1, s);//find even
        }
        return s.substring(startPos, startPos+maxLen);
    }
    private void findMaxPalin(int left, int right, String s){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int currLen = right - left - 1;
        if(currLen > maxLen){
            maxLen = currLen;
            startPos = left + 1;
        }
    }
}

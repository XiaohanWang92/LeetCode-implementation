public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length() || t.length() == 0) return "";
        int[] sTable = new int[256];
        int[] tTable = new int[256];
        for(int i = 0; i < t.length(); i++) {
            tTable[t.charAt(i)]++;
        }
        
        // number of char in t found in s
        int find = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";
        int left = 0, right = 0;
        while(right < s.length()) {
            
            // when find == t.length, it means all chars in t have been found
            // if not, right should be expanded
            if(find < t.length()) {
                if(tTable[s.charAt(right)] > 0) {
                    sTable[s.charAt(right)]++;
                    
                    // notice <=, which means s and t can have duplicate chars
                    // when tTable corresponding char's num > sTable, it is not a valid find++
                    // for example, "aabbcc" and "abc", the 2nd a in "aabbcc" should not trigger a find++
                    if(sTable[s.charAt(right)] <= tTable[s.charAt(right)]) {
                        find++;
                    }
                }
                right++;
            }
            
            // when all chars in t have been found, we shrink window by move left 1 step by step
            while(find == t.length()) {
                
                // notice that right is exclusive
                if(right - left < minLength) {
                    minLength = right - left;
                    result = s.substring(left, right);
                }
                if(tTable[s.charAt(left)] > 0) {
                    sTable[s.charAt(left)]--;
                    if(tTable[s.charAt(left)] > sTable[s.charAt(left)]) {
                        find--;
                    }
                }
                left++;
            }
        }
        return result;
    }
}

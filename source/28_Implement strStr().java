public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null||haystack.length()<needle.length()) return -1;
        if(needle.equals("")) return 0;
        int result = 0;
        for(int i=0,j=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.charAt(i)==needle.charAt(j))
                if(haystack.substring(i,needle.length()+i).equals(needle))
                    return i;
        }
        return -1;
    }
}

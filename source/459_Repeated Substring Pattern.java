public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if(str.length() <= 1)   return false;
        int length = str.length();
        
        // pLen stands for possible repeated pattern length
        for(int pLen = 1; pLen <= length / 2; pLen++) {
            if(length % pLen == 0) {
                String pattern = str.substring(0, pLen);
                boolean isRepeatedPattern = true;
                for(int i = pLen; i < length; i += pLen) {
                    if(!str.substring(i, i + pLen).equals(pattern)) {
                        isRepeatedPattern = false;
                        break;
                    }
                }
                if(isRepeatedPattern)   return true;
            }
        }
        return false;
    }
}

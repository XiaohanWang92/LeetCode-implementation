public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0)    return -1;
        char[] count = new char[26];
        char[] charArr = s.toCharArray();
        for(char c : charArr) {
            int index = c - 'a';
            count[index]++;
        }
        for(int i = 0; i < charArr.length; i++) {
            int index = charArr[i] - 'a';
            if(count[index] == 1)   return i;
        }
        return -1;
    }
}

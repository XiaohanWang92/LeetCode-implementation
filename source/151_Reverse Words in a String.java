public class Solution {
    public String reverseWords(String s) {
        String trimS = s.trim();
        String[] words=trimS.split(" +");
        StringBuffer stb = new StringBuffer();
        for(int i = words.length - 1; i > 0; i--) {
            stb.append(words[i]);
            stb.append(" ");
        }
        stb.append(words[0]);
        return stb.toString();
    }
}

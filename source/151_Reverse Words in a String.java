public class Solution {
    public String reverseWords(String s) {
        String trims = s.trim();
        String[] words=trims.split(" +");
        StringBuffer stb = new StringBuffer();
        for(int i=words.length-1;i>0;i--){
            stb.append(words[i]);
            stb.append(" ");
        }
        stb.append(words[0]);
        return stb.toString();
    }
}

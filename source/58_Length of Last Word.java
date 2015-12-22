public class Solution {
    public int lengthOfLastWord(String s) {
        String cuts = s.trim();
        int lastSpace = cuts.lastIndexOf(" ");
        return cuts.length()-lastSpace-1;
    }
}
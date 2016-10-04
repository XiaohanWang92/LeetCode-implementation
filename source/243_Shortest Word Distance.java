public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Index = -1, word2Index = -1;
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1))
                word1Index = i;
            if(words[i].equals(word2))
                word2Index = i;
            if(word1Index != -1 && word2Index != -1) {
                minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index));
            }
        }
        return minDistance;
    }
}

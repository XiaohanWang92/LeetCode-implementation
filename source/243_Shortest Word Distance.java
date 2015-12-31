public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i=-1,j=i; int currentMin=Integer.MAX_VALUE;
        for(int k=0;k<words.length;k++){
            if(words[k].equals(word1)){
                i=k;
                if(j!=-1){
                    currentMin=Math.min(Math.abs(i-j),currentMin);
                }
            }
            if(words[k].equals(word2)){
                j=k;
                if(i!=-1){
                    currentMin=Math.min(Math.abs(i-j),currentMin);
                }
            }
        }
        return currentMin;
    }
}

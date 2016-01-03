public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pre=-1, next=pre, currMin=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)||words[i].equals(word2)){
                if(words[i].equals(word1)){
                    if(!word1.equals(word2))    pre=i;
                }
                if(words[i].equals(word2)){
                    if(word1.equals(word2)){
                        pre=next;
                    }
                    next=i;
                }
                if(pre!=-1&&next!=-1){
                    currMin=Math.min(Math.abs(pre-next),currMin);
                }
            }
        }
        return currMin;
    }
}

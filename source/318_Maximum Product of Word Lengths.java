public class Solution {
    public int maxProduct(String[] words) {
        int[] id = new int[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j=0;j<words[i].length();j++){
                id[i] = id[i]|(1<<(words[i].charAt(j)-'a'));
            }
        }
        int max=0;
        for(int i=0;i<id.length;i++){
            for(int j=i+1;j<id.length;j++){
                if((id[i]&id[j])==0)
                    max = Math.max(max, words[i].length()*words[j].length());
            }
        }
        return max;
    }
}

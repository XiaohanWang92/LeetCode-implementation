public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordList.add(endWord);
        int dist=1;
        while(!reached.contains(endWord)){
            Set<String> addword = new HashSet<>();
            for(String s : reached){
                for(int i=0;i<s.length();i++){
                    char[] schar = s.toCharArray();
                    for(char c='a';c<='z';c++){
                        schar[i]=c;
                        String genWord = new String(schar);
                        if(wordList.contains(genWord)){
                            addword.add(genWord);
                            wordList.remove(genWord);
                        }
                    }
                }
            }
            dist++;
            if(addword.size()==0)   return 0;
            reached = addword;
        }
        return dist;
    }
}

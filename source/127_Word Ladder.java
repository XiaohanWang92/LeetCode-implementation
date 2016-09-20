public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> currentReachedWords = new HashSet<>();
        currentReachedWords.add(beginWord);
        wordList.add(endWord);
        int distance = 1;
        while(!currentReachedWords.contains(endWord)) {
            Set<String> temp = new HashSet<>();
            for(String s : currentReachedWords) {
                for(int i = 0; i < s.length(); i++) {
                    char[] c = s.toCharArray();
                    for(char replaceChar = 'a'; replaceChar <= 'z'; replaceChar++) {
                        if(c[i] == replaceChar) continue;
                        c[i] = replaceChar;
                        String transformation = new String(c);
                        if(wordList.contains(transformation)) {
                            wordList.remove(transformation);
                            temp.add(transformation);
                        }
                    }
                }
            }
            if(temp.size() == 0)    return 0;
            currentReachedWords = temp;
            distance++;
        }
        return distance;
    }
}

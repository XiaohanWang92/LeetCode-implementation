public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if(s == null || words == null || s.length() == 0 || words.length == 0)   return results;
        Map<String, Integer> occurMap = new HashMap<>();
        for(String word : words) {
            occurMap.put(word, occurMap.containsKey(word) ? occurMap.get(word) + 1 : 1);
        }
        int wordSize = words[0].length();
        for(int i = 0; i <= s.length() - wordSize * words.length; i++) {
            Map<String, Integer> countMap = new HashMap<>(occurMap);
            for(int j = 0; j < words.length; j++) {
                String currWord = s.substring(i + j * wordSize, i + (j + 1) * wordSize);
                if(countMap.containsKey(currWord)) {
                    int count = countMap.get(currWord);
                    if(count == 1)  countMap.remove(currWord);
                    else countMap.put(currWord, count - 1);
                    if(countMap.isEmpty()) {
                        results.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return results;
    }
}

public class Solution {
    
    Map<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> results = new ArrayList<>();
        if(map.containsKey(s))
            return map.get(s);

        // s itself is contained
        if(wordDict.contains(s)) {
            results.add(s);
        }

        // several parts of s are contained
        for(int i = 0; i < s.length(); i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                String prefix = s.substring(0, i);
                List<String> prefixResults = wordBreak(prefix, wordDict);
                if(prefixResults.size() != 0) {
                    for(int j = 0; j < prefixResults.size(); j++) {
                        String result = prefixResults.get(j) + " " + t;
                        results.add(result);
                    }
                }
            }
        }
        map.put(s, results);
        return results;
    }
}

public class WordDistance {
    private Map<String, ArrayList<Integer>> dist = new HashMap<>();

    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++) {
            if(dist.containsKey(words[i])) {
                List l = dist.get(words[i]);
                l.add(i);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                dist.put(words[i], l);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int currMin = Integer.MAX_VALUE;
        List<Integer> l1 = dist.get(word1);
        List<Integer> l2 = dist.get(word2);
        for(int i : l1) {
            for(int j: l2) {
                currMin = currMin > Math.abs(i - j) ? Math.abs(i - j) : currMin;
            }
        }
        return currMin;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> results =  new ArrayList<>();
        backTrack(results, "", 0, 0, word);
        return results;
    }

    private void backTrack(List<String> results, String currentS, int pos, int abbrCount, String word) {
        if(pos != word.length()) {
            backTrack(results, currentS, pos + 1, abbrCount + 1, word);
            backTrack(results, currentS + (abbrCount == 0 ? "" : abbrCount) + word.charAt(pos), pos + 1, 0, word);
        } else {
            if(abbrCount != 0) {
                currentS = currentS + abbrCount;
            }
            results.add(currentS);
        }
    }
}

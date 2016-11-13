public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list, results);
        return results;
    }

    private void dfs(String s, int pos, List<String> list, List<List<String>> results) {
        if(pos == s.length()) results.add(new ArrayList<String>(list));
        else {
            for(int i = pos; i < s.length(); i++) {
                if(isPal(s, pos, i)) {
                    list.add(s.substring(pos, i + 1));
                    dfs(s, i + 1, list, results);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPal(String s, int low, int high) {
        while(low < high) if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}

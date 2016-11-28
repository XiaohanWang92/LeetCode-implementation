public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(results, board, i, j, root);
            }
        }
        return results;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                int index = c - 'a';
                if(curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }
            curr.word = word;
        }
        return root;
    }
    
    private void dfs(List<String> results, char[][] board, int i, int j, TrieNode node) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;
        char c = board[i][j];
        if(c == '*' || node.children[c - 'a'] == null)  return;
        node = node.children[c - 'a'];
        if(node.word != null) {
            results.add(node.word);
            node.word = null;
        }
        board[i][j] = '*';
        dfs(results, board, i + 1, j, node);
        dfs(results, board, i - 1, j, node);
        dfs(results, board, i, j + 1, node);
        dfs(results, board, i, j - 1, node);
        board[i][j] = c;
    }
}

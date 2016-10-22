class TrieNode {
    
    boolean isWord;
    TrieNode[] childNodes;

    // Initialize your data structure here.
    public TrieNode() {
        isWord = false;
        childNodes = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            if(cur.childNodes[word.charAt(i) - 'a'] == null) {
                TrieNode tmp = new TrieNode();
                cur.childNodes[word.charAt(i) - 'a'] = tmp;
                cur = tmp;
            } else {
                cur = cur.childNodes[word.charAt(i) - 'a'];
            }
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            if(cur.childNodes[word.charAt(i) - 'a'] == null) {
                return false;
            } else {
                cur = cur.childNodes[word.charAt(i) - 'a'];
            }
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            if(cur.childNodes[prefix.charAt(i) - 'a'] == null) {
                return false;
            } else {
                cur = cur.childNodes[prefix.charAt(i) - 'a'];
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
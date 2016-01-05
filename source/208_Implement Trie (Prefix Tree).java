class TrieNode {
    // Initialize your data structure here.
    private final int size=26;
    private TrieNode[] children;
    private String entry;
    private boolean isWord;
    public TrieNode() {
        children = new TrieNode[size];
        entry="";
    }
    public String getWord(){
        return entry;
    }
    public void setWord(String word){
        entry=word;
    }
    public TrieNode[] getChildren(){
        return children;
    }
    public TrieNode getOneChild(int i){
        if(i<0||i>25)   return null;
        return children[i];
    }
    public void setOneChild(int index, TrieNode child){
        if(index<0||index>25)   return;
        children[index] = child;
    }
    public boolean isWord(){
        return isWord;
    }
    public void setIsWord(boolean b){
        isWord=b;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.getOneChild(ch-'a')==null){
                curr.setOneChild(ch-'a', new TrieNode());
            }
            curr=curr.getOneChild(ch-'a');
        }
        curr.setWord(word);
        curr.setIsWord(true);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        char[] chword = word.toCharArray();
        for(Character ch : chword){
            if(curr.getOneChild(ch-'a')==null)  return false;
            curr=curr.getOneChild(ch-'a');
        }
        return curr.isWord();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] chpref = prefix.toCharArray();
        for(Character ch : chpref){
            if(curr.getOneChild(ch-'a')==null)  return false;
            curr = curr.getOneChild(ch-'a');
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

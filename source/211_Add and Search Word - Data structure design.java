public class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String entry = "";
        boolean isWord = false;
    }
    
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.entry = word;
        curr.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return findHelper(word.toCharArray(), 0, root);//root is level zero
    }
    private boolean findHelper(char[] word, int id, TrieNode curr){
//id has checked index 0 to length-1, now check if reference passed in is a word in dict.        
        if(id==word.length) return curr.isWord;
        if(word[id]!='.'){
            if(curr.children[word[id]-'a']==null)   return false;
            return findHelper(word, id+1, curr.children[word[id]-'a']);
        }else{
            for(int i=0; i<curr.children.length;i++){
                if(curr.children[i]!=null){
                    if(findHelper(word, id+1, curr.children[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

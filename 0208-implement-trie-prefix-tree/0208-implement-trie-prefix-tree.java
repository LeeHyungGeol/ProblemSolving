class TrieNode {
    char val;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
    
    TrieNode() {}

    TrieNode(char val) {
        this.val = val;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
        root.val = ' ';
    }
    
    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            int index = c-'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode(c);
            }
            current = current.children[index];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            int index = c-'a';

            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        
        for (char c : prefix.toCharArray()) {
            int index = c-'a';

            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
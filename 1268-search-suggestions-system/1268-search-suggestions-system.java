import java.util.*;

class Solution {
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        List<String> words = new ArrayList<>();
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;

            for (char c : word.toCharArray()) {
                int index = c-'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
                if (current.words.size() < 3) {
                    current.words.add(word);
                }
            }
            current.isWord = true;
        }

        public List<String> autoComplete(String word) {
            TrieNode prefix = searchPrefix(word);

            if (prefix == null) return new ArrayList<>();
            return prefix.words;
        }

        private TrieNode searchPrefix(String prefix) {
             TrieNode current = root;

            for (char c : prefix.toCharArray()) {
                int index = c-'a';

                if (current.children[index] == null) return null;
                current = current.children[index];
            }
            return current;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> answer = new ArrayList<>();
        Trie trie = new Trie();

        Arrays.sort(products);

        for (String product : products) {
            trie.insert(product);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            answer.add(trie.autoComplete(sb.toString()));
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }
    
    class Trie {
        TrieNode root = new TrieNode();
        
        void insert(String word) {
            TrieNode node = root;
            node.count++; 
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.count++;
            }
        }
        
        int count(String q) {
            TrieNode node = root;
            for (char c : q.toCharArray()) {
                if (c == '?') break; 
                int idx = c - 'a';
                if (node.children[idx] == null) return 0;
                node = node.children[idx];
            }
            return node.count;
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> frontTries = new HashMap<>();
        Map<Integer, Trie> backTries = new HashMap<>();
        
        for (String word : words) {
            int len = word.length();
            frontTries.putIfAbsent(len, new Trie());
            backTries.putIfAbsent(len, new Trie());
            
            frontTries.get(len).insert(word);
            backTries.get(len).insert(new StringBuilder(word).reverse().toString());
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();
            
            if (query.charAt(0) == '?') {
                Trie trie = backTries.get(len);
                answer[i] = trie == null ? 0 : 
                    trie.count(new StringBuilder(query).reverse().toString());
            } else {
                Trie trie = frontTries.get(len);
                answer[i] = trie == null ? 0 : trie.count(query);
            }
        }
        
        return answer;
    }
}
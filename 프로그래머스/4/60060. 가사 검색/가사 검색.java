import java.util.*;


class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        int children = 0;
    }
   
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> map = new HashMap<>();
        Map<Integer, Trie> revMap = new HashMap<>();
       
        for (String w : words) {
            map.putIfAbsent(w.length(), new Trie());
            revMap.putIfAbsent(w.length(), new Trie());
            buildTrie(w, map.get(w.length()));
            buildTrie(new StringBuilder(w).reverse().toString(), revMap.get(w.length()));
        }
       
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int wc = 0;
           
            if (map.containsKey(q.length())) {
                if (q.charAt(0) == '?') {
                    wc = count(new StringBuilder(q).reverse().toString(), revMap.get(q.length()), 0);
                } else {
                    wc = count(q, map.get(q.length()), 0);
                }
            }
            answer[i] = wc;
        }
       
        return answer;
    }
   
    private int count(String s, Trie node, int idx) {
        char c = s.charAt(idx);
       
        if (c == '?') {
            return node.children;
        }
       
        if (node.next[c - 'a'] == null) {
            return 0;
        }
       
        return count(s, node.next[c - 'a'], idx + 1);
    }
   
    private void buildTrie(String w, Trie node) {
        node.children++;
       
        for (char c : w.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
           
            node = node.next[c - 'a'];
            node.children++;
        }
    }
}


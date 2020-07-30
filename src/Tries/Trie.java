package Tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    public Trie(TrieNode root) {
        this.root = root;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    //iteratively insertion into trie
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            //if children has ch in its map
            TrieNode node = current.children.get(ch);
            //if doesn't have
            if (node == null) {
                //so we create a new node and put ch into that node
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //now we mark current node's endOfWord as true;
        current.endOfWord = true;
    }
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }
    private void insertRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        //if node is not in map, then create one and put in map
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index+1);
    }
}

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

    //O(l*n) length of word * numbers of words
    //iteratively insertion into trie
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            //if there is a node for that given ch,
            // set it to = to node, and move along until we reach the end of the word
            TrieNode node = current.children.get(ch);
            //if it's not in the Trie, then we add it to the Trie
            if (node == null) {
                //so we create a new node and put ch into that hashmap
                node = new TrieNode();
                current.children.put(ch, node);
            }
            //current = the last node created
            current = node;
        }
        //now we mark current node's endOfWord as true;
        current.endOfWord = true;
    }
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }
    private void insertRecursive(TrieNode current, String word, int index) {
        //if out of bounds
        if (index == word.length()) {
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        //if node is not in the trie, then create node and put it in the trie
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        //if node already existed, it passes along so you move onto
        insertRecursive(node, word, index+1);
    }

    //search O(l)
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false; //false if node is not there
            }
            current = node;
        }
        return current.endOfWord;//return true or false accordingly
    }


}

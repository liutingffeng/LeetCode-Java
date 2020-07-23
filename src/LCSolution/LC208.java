package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC208 {
    class TrieNode{
        int value;
        boolean end;
        TrieNode[] next;

        public TrieNode(int value){
            this.value = value;
            next = new TrieNode[26];
        }

    }


    class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode(-1);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for (int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(cur.next[index]==null){
                    cur.next[index] = new TrieNode(1);
                }
                cur = cur.next[index];
            }
            cur.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode cur = root;
            for (int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(cur.next[index]==null){
                    return false;
                }
                cur = cur.next[index];
            }
            return cur.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i=0;i<prefix.length();i++){
                int index = prefix.charAt(i)-'a';
                if(cur.next[index]==null){
                    return false;
                }
                cur = cur.next[index];
            }
            return true;
        }
    }
}

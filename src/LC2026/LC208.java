package LC2026;

import java.util.ArrayList;
import java.util.List;

public class LC208 {

    static class Trie {

        class Node {
            boolean isWord;
            char val;
            Node[] next;

            public Node(char c) {
                val = c;
            }
        }

        private Node root;

        public Trie() {
            root = new Node('0');
        }

        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            Node cur = root;
            for (char w : word.toCharArray()) {
                if (cur.next == null) {
                    cur.next = new Node[26];
                }
                if (cur.next[w - 'a'] == null) {
                    cur.next[w - 'a'] = new Node(w);
                }
                cur = cur.next[w - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            if (word == null || word.isEmpty())
                return false;
            Node cur = root;
            for (char w : word.toCharArray()) {
                if (cur.next == null) {
                    return false;
                }
                cur = cur.next[w - 'a'];
                if (cur == null)
                    return false;
            }
            if (cur.isWord)
                return true;
            return false;
        }

        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.isEmpty())
                return false;
            Node cur = root;
            for (char w : prefix.toCharArray()) {
                if (cur.next == null) {
                    return false;
                }
                cur = cur.next[w - 'a'];
                if (cur == null)
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        LC208 a = new LC208();
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }
}

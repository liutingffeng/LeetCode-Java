package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC146 {

    class Node{
        int key;
        int val;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
        public Node pre;
        public Node next;
    }

    class DoubleNode{
        public int count;
        private Node head;
        private Node tail;

        public DoubleNode(){
            count = 0;
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Node node){
            Node next = head.next;
            head.next = node;
            node.next = next;
            next.pre = node;
            node.pre = head;
            count++;
        }

//        public void addLast(Node node){
//            Node pre = tail.pre;
//            pre.next = node;
//            node.next = tail;
//            tail.pre = node;
//            node.pre = pre;
//            count++;
//        }

        public void add(Node node){
            addFirst(node);
        }

        public void remove(Node node){
            Node pre = node.pre;
            Node next = node.next;
            node.pre = null;
            node.next = null;
            pre.next = next;
            next.pre = pre;
            count--;
        }

        public Node removeLast(){
            Node node = tail.pre;
            remove(node);
            return node;
        }

    }


    class LRUCache {
        private DoubleNode doubleNode;
        private Map<Integer,Node> map;
        private int cap;

        public LRUCache(int capacity) {
            doubleNode = new DoubleNode();
            map = new HashMap<>();
            cap = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)){
                Node node = map.get(key);
                doubleNode.remove(node);
                doubleNode.addFirst(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                Node node = map.remove(key);
                doubleNode.remove(node);
                Node newNode = new Node(key,value);
                doubleNode.add(newNode);
                map.put(key, newNode);
            }
            else {
                if (cap == map.size()){
                    Node node = doubleNode.removeLast();
                    map.remove(node.key);
                }
                Node node = new Node(key,value);
                doubleNode.add(node);
                map.put(key, node);
            }
        }
    }
}

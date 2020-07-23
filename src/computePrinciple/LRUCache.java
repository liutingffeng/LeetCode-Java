package computePrinciple;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private DoubleLinkedList list;
    private int capacity;
    private Map<Integer,Node> map;

    public LRUCache(int c){
        capacity = c;
        list = new DoubleLinkedList(c);
        map = new HashMap<>();
    }

    public int get(int key){
        if (map.containsKey(key)){
            Node node = map.get(key);
            list.remove(node);
            list.addHead(node);
            return node.value;
        }
        else
            return -1;
    }

    public void put(int key,int value){
        if (map.containsKey(key)){
            Node node = map.get(key);
            list.remove(node);
            node.value = value;
            list.addHead(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (list.getSize()>=capacity){
                Node oldNode = list.remove();
                map.remove(oldNode.key);
            }
            list.addFront(node);
        }
    }

    public void print(){
        list.print();
    }

    public static void main(String[] args) {
        LRUCache cache  = new LRUCache(2);
        cache.put(1, 1);
        cache.print();
        cache.put(2, 2);
        cache.print();
        cache.put(3, 3);
        cache.print();
        System.out.println(cache.get(1));
        cache.print();
        System.out.println(cache.get(2));
        cache.print();
        System.out.println(cache.get(3));
        cache.print();
    }
}

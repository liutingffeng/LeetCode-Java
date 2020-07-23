package computePrinciple;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class FIFOCache {
    private DoubleLinkedList list;
    private int capacity;
    private int size;
    private Map<Integer,Node> map;

    public FIFOCache(int c){
        capacity = c;
        list = new DoubleLinkedList(c);
        map = new HashMap<>();
    }

    public int get(int key){
        if (map.containsKey(key)){
            return map.get(key).value;
        }
        else
            return -1;
    }

    public void put(int key,int value){
        if (capacity == 0)
            return;

        if (map.containsKey(key)){
            Node node = map.get(key);
            list.remove(node);
            node.value = value;
            list.add(node);
        }
        else {
            if (size == capacity){
                Node node = list.pop();
                map.remove(node.key);
                size -=1;
            }
            Node node = new Node(key, value);
            map.put(key, node);
            list.add(node);
            size +=1;
        }
    }

    public void print(){
        list.print();
    }

    public static void main(String[] args) {
        FIFOCache cache = new FIFOCache(2);
        cache.put(1,1);
        cache.print();
        cache.put(2, 2);
        cache.print();
        System.out.println(cache.get(1));
        cache.put(3, 3);
        cache.print();
        System.out.println(cache.get(2));
        cache.print();
        cache.put(4, 4);
        cache.print();
        System.out.println(cache.get(1));
        
    }
}

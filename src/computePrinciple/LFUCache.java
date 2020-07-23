package computePrinciple;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//相同频率的节点放在一个链表里
public class LFUCache {


    class LFUNode extends Node{
        public int freq;
        public LFUNode(int key,int value){
            super(key,value);
        }
    }

    private int capacity;
    private int size;
    private Map<Integer,LFUNode> map;

    //key 频率  
    private Map<Integer,DoubleLinkedList> freq_map;

    public LFUCache(int c){
        capacity = c;
        map = new HashMap<>();
        freq_map = new HashMap<>();
    }

    //更新节点频率的参数
    private void updateFreq(LFUNode node){
        int freq = node.freq;
        node = (LFUNode) freq_map.get(freq).remove(node);
        if (freq_map.get(freq).getSize() == 0){
            freq_map.remove(freq);
        }
        freq +=1;
        node.freq = freq;
        if (!freq_map.containsKey(freq)){
            freq_map.put(freq, new DoubleLinkedList());
        }
        freq_map.get(freq).add(node);
    }

    public int get(int key){
        if (!map.containsKey(key))
            return -1;

        LFUNode node = map.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key,int value){
        if (capacity == 0)
            return;
        if (map.containsKey(key)){
            LFUNode node = map.get(key);
            node.value = value;
            updateFreq(node);
        }
        else {
            if (capacity == size){
                int minFreq = getMinFreq();
                Node popNode = freq_map.get(minFreq).pop();
                map.remove(popNode.key);
                size -=1;
            }
            LFUNode newNode = new LFUNode(key, value);
            newNode.freq = 1;
            map.put(key, newNode);
            if (!freq_map.containsKey(newNode.freq)){
                freq_map.put(newNode.freq, new DoubleLinkedList());
            }
            freq_map.get(newNode.freq).add(newNode);
            size +=1;
        }
    }

    public int getMinFreq(){
        return Collections.min(freq_map.keySet());
    }

    public void print(){
        System.out.println("=============");
        for (int key:freq_map.keySet()){
            System.out.print("freq="+key+": ");
            freq_map.get(key).print();
        }
        System.out.println("=============");
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(4);
        cache.put(1, 1);
        cache.print();
        cache.put(2, 2);
        cache.print();
        System.out.println(cache.get(1));
        cache.print();
        cache.put(3, 3);
        cache.print();
        System.out.println(cache.get(2));
        cache.print();
        System.out.println(cache.get(3));
        cache.print();
        cache.put(4, 4);
        cache.print();
        cache.put(5, 5);
        cache.print();
    }

}

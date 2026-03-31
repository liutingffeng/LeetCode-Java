package LC2026;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used) 缓存实现
 * 使用 HashMap + 双向链表，实现 O(1) 的 get 和 put 操作
 *
 * @Author liutingfeng
 * @Date 2026/3/31 15:43
 */
public class LCLRU {

    // 双向链表节点
    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private final int capacity;
    private final DLinkedNode head;  // 虚拟头节点
    private final DLinkedNode tail;  // 虚拟尾节点
    private int size;

    public LCLRU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 使用虚拟头尾节点简化边界处理
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加到双向链表头部
            addToHead(newNode);
            size++;
            // 如果超出容量，删除双向链表的尾部节点
            if (size > capacity) {
                DLinkedNode removed = removeTail();
                // 删除哈希表中对应的项
                cache.remove(removed.key);
                size--;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 将节点添加到头部
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将节点移到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除尾部节点（最久未使用的节点）
    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        LCLRU lru = new LCLRU(2);

        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // 返回 1
        lru.put(3, 3); // 该操作会使得 key=2 被删除
        System.out.println(lru.get(2)); // 返回 -1 (未找到)
        lru.put(4, 4); // 该操作会使得 key=1 被删除
        System.out.println(lru.get(1)); // 返回 -1 (未找到)
        System.out.println(lru.get(3)); // 返回 3
        System.out.println(lru.get(4)); // 返回 4
    }
}

package LCSolution;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class LC138 {

    class Solution {

        //还有一种思路是将复制的节点放在原节点的后面，这样不用map
        // O(1) 空间复杂度
        //i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        public Node copyRandomList(Node head) {
            if (head == null)
                return head;


            Map<Node,Node> map = new HashMap<>();
            Node newNode = new Node(head.val);

            int count = 0;
            map.put(head,newNode);

            Node newCur = newNode;
            Node cur = head.next;
            while (cur!=null){
                newCur.next = new Node(cur.val);
                map.put(cur, newCur.next);
                cur = cur.next;
                newCur = newCur.next;
            }

            cur = head;
            newCur = newNode;
            while (cur!=null){
                newCur.random = map.get(cur.random);
                cur = cur.next;
                newCur = newCur.next;
            }

            return newNode;
        }
    }
}

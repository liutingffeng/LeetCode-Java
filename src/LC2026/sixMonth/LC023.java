package LC2026.sixMonth;

import LC2025.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (node1, node2) -> node1.val - node2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return res.next;
    }
}

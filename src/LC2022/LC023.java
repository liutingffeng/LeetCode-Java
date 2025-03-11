package LC2022;

import java.util.List;

public class LC023 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode minNode = null;
        int minIndex = -1;
        // 找到最小的
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node == null)
                continue;
            if (minNode == null) {
                minIndex = i;
                minNode = node;
                continue;
            }
            if (node.val < minNode.val) {
                minNode = node;
                minIndex = i;
            }
        }
        if (minNode == null) {
            return null;
        }
        lists[minIndex] = lists[minIndex].next;
        minNode.next = mergeKLists(lists);
        return minNode;
    }

    public static void main(String[] args) {

    }
}

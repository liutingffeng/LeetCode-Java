package LC2025;

import java.util.List;

public class LC019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        ListNode x = new ListNode(0);
        x.next = head;
        ListNode slow = x;
        ListNode fast = x;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode f = x;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return f.next;
    }
}

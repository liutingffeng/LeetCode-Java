package LC2025;

public class LC024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = null;

        while (first != null && second != null) {
            // 开始交换
            third = second.next;
            pre.next = second;
            second.next = first;
            first.next = third;

            pre = first;
            first = third;

            if (first == null)
                break;
            second = first.next;
        }
        return res.next;
    }
}

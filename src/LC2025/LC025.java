package LC2025;

public class LC025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        return recur(head, k);
    }

    private ListNode recur(ListNode head, int k) {
        // 寻找end
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode end = pre;
        int step = k;
        while (step > 0) {
            if (end == null)
                return head;
            end = end.next;
            step--;
        }
        if (end == null) {
            return head;
        }
        // 翻转
        ListNode endNext = end.next;
        ListNode newHead = reverse(head, end);
        ListNode t = recur(endNext, k);
        pre.next.next = t;
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        if (head == null || head.next == null)
            return head;
        if (head == end) {
            return head;
        }
        ListNode res = reverse(head.next, end);
        ListNode revEnd = head.next;
        revEnd.next = head;
        head.next = null;
        return res;
    }


    public static void main(String[] args) {
        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(2);
        ListNode x3 = new ListNode(3);
        ListNode x4 = new ListNode(4);
        ListNode x5 = new ListNode(5);


        ListNode pre = new ListNode(-1);
        pre.next = x1;
        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        x4.next = x5;

        ListNode res = new LC025().reverseKGroup(x1, 2);
        int a = 1;
    }
}

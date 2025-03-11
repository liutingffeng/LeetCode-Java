package LC2022;

import java.util.ArrayList;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class LC019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> temp = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            temp.add(cur);
            cur = cur.next;
        }
        int m = temp.size() - n;
        if (m == 0)
            return head.next;
        temp.get(m-1).next = temp.get(m-1).next.next;
        return head;
    }


    public static void main(String[] args) {

    }
}

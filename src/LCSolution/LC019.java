package LCSolution;

public class LC019 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = head;
            ListNode fast = head;
            ListNode pre = dummy;
            while (n-->0){
                fast = fast.next;
            }

            while (fast!=null){
                slow = slow.next;
                pre = pre.next;
                fast = fast.next;
            }

            //删除头结点
            if (slow == head){
                return dummy.next.next;
            }

            pre.next = slow.next;
            return head;
        }
    }
}

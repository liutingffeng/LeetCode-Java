package LCSolution;

public class LC061 {

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null)
                return head;
            int count = 0;
            ListNode cur = head;
            while (cur!=null){
                count++;
                cur = cur.next;
            }
            k %=count;
            //不用旋转
            if (k==0)
                return head;
//            LCSolution.ListNode dummy = new LCSolution.ListNode(-1);
//            dummy.next = head;
            ListNode slow = head;
            ListNode fast = head;
            while (k-->0)
                fast = fast.next;
            while (fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = head;
            head = slow.next;
            slow.next = null;
            return head;
        }
    }
}

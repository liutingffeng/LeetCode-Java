package LCSolution;

public class LC203 {

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null)
                return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            while (head!=null){
                if (head.val == val){
                    pre.next = head.next;
                }
                else {
                    pre = pre.next;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
}

package LCSolution;

public class LC083 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = head;
            head = head.next;
            while (head!=null){
                if (head.val == pre.val){
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

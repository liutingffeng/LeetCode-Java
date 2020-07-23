package LCSolution;

public class LC082 {

    class Solution {
        //可以用递归
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode start = head;
            ListNode end = head.next;
            while (end!=null){
                if (end.val!=start.val){
                    end = end.next;
                    start = start.next;
                    pre = pre.next;
                }
                else {
                    while (end.next!=null && end.val==start.val){
                        end = end.next;
                    }
                    if (end.val == start.val){
                        pre.next = end.next;
                        end = null;
                    }
                    else {
                        pre.next = end;
                        start = end;
                        end = end.next;
                    }
                }
            }
            return dummy.next;
        }
    }
}

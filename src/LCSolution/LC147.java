package LCSolution;

import org.junit.Test;

public class LC147 {

    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = head;
            head = head.next;
            while (head!=null){
                ListNode hair = dummy;
                if (head.val>=pre.val){
                    //不用插
                    head = head.next;
                    pre = pre.next;
                    continue;
                }
                while (hair.next!=head){
                    if (hair.next.val>head.val){
                        pre.next = head.next;
                        head.next = hair.next;
                        hair.next = head;
                        head = pre.next;
                        break;
                    }
                    else {
                        hair = hair.next;
                    }
                }
            }
            return dummy.next;
        }
    }

    @Test
    public void t(){
        ListNode head = new ListNode(4);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;

        new Solution().insertionSortList(head);
    }
}

package LCSolution;

public class LC086 {

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummyp = new ListNode(-1);
            ListNode dummyl = new ListNode(-1);
            ListNode tailp = dummyp;
            ListNode taill = dummyl;
            ListNode cur = head;
            while (cur!=null){
                if (cur.val<x){
                    taill.next = cur;
                    taill = cur;
                }
                else {
                    tailp.next = cur;
                    tailp = cur;
                }
                cur = cur.next;
            }
            tailp.next = null;
            taill.next = dummyp.next;
            return dummyl.next;
        }
    }
}

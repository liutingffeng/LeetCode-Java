package LCSolution;

public class LC024 {

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;
            //交换
            ListNode nex = head.next;
            head.next = swapPairs(nex.next);
            nex.next = head;
            return nex;
        }
    }
}

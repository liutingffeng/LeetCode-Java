package LCSolution;

public class LC328 {

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null)
                return head;

//            LCSolution.ListNode dummyOdd = new LCSolution.ListNode(-1);
//            LCSolution.ListNode dummyEven = new LCSolution.ListNode(-1);
//            LCSolution.ListNode tailOdd = dummyOdd;
//            LCSolution.ListNode tailEven = dummyEven;
//            LCSolution.ListNode cur = head;
            ListNode o = head;
            ListNode p = head.next;
            ListNode e = p;
            while (o.next!=null && e.next!=null){
                o.next = e.next;
                o = e.next;
                e.next = o.next;
                e = o.next;
            }
            o.next = p;
            return head;
        }
    }
}

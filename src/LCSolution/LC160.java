package LCSolution;

public class LC160 {

    class Solution {
//        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//            ListNode pA = headA;
//            ListNode pB = headB;
//
//            while (pA!=pB){
//                pA = pA == null? headB:pA.next;
//                pB = pB == null? headA:pB.next;
//            }
//
//            return pA;
//
//        }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA;
            ListNode pB = headB;

            while (pA!=pB){
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
}

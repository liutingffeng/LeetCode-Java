package LCSolution;

public class LC021 {

//    输入：1->2->4, 1->3->4
//    输出：1->1->2->3->4->4
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if (l1 == null || l2 == null){
                return l1 == null ? l2:l1;
            }

            if (l1.val>l2.val){
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
            else {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
        }
    }

}

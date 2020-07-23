package LCSolution;


class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
}


public class LC002 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           return resc(l1,l2,0);
        }

        private ListNode resc(ListNode l1, ListNode l2, int addBit) {
             if (l1 == null && l2 == null){
                 return addBit == 0? null:new ListNode(addBit);
             }

             int val1 = l1==null ? 0:l1.val;
             int val2 = l2==null ? 0:l2.val;
             int count = val1+val2+addBit;
             ListNode newNode = new ListNode(count%10);
             newNode.next = resc(l1==null? null:l1.next, l2==null? null:l2.next, count/10);
             return newNode;

        }
    }
}

package LCSolution;

public class LC445 {

    class Solution {

        //还可以用栈存储，再pop
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //反转链表
            l1 = reverseList(l1);
            l2 = reverseList(l2);
            ListNode head = rescAdd(l1, l2, 0);
            return reverseList(head);
        }

        private ListNode rescAdd(ListNode l1,ListNode l2,int addbit){
            if (l1 == null && l2 == null){
                return addbit == 0 ? null : new ListNode(addbit);
            }

            int val1 = l1 == null ? 0:l1.val;
            int val2 = l2 == null ? 0:l2.val;
            int sum = val1+val2+addbit;
            ListNode newNode = new ListNode(sum%10);
            newNode.next = rescAdd(l1 == null ? null:l1.next, l2==null ? null:l2.next, sum/10);
            return newNode;
        }

        private ListNode reverseList(ListNode head){
            if (head == null || head.next == null)
                return head;

            ListNode pre = null;
            while (head!=null){
                ListNode nex = head.next;
                head.next = pre;
                pre = head;
                head = nex;
            }
            return pre;
        }
    }
}

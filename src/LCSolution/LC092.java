package LCSolution;

public class LC092 {

    static class Solution {
//        public ListNode reverseBetween(ListNode head, int m, int n) {
//            if (head == null || head.next == null)
//                return head;
//            ListNode dummy = new ListNode(-1);
//            dummy.next = head;
//            ListNode start = dummy;
//            ListNode ppre = dummy;
//            int len = n-m+1;
//            while (m-->0){
//                ppre = start;
//                start = start.next;
//            }
//            ListNode tail = start;
//            //开始反转
//            ListNode pre = null;
//            while (len-->0){
//                ListNode next = start.next;
//                start.next = pre;
//                pre = start;
//                start = next;
//            }
//            ppre.next = pre;
//            tail.next = start;
//            return dummy.next;
//        }


        public ListNode reverseBetween(ListNode head, int m, int n) {

            int changeLength = n-m+1;
            //找到开始反转的节点的前一个节点
            ListNode preHead = null;
            ListNode res = head;

            while (head!=null && --m > 0){
                preHead = head;
                head = head.next;
            }

            //开始反转
            ListNode modifyTail = head;
            ListNode newNode = null;
            ListNode next = null;
            while (head!=null && changeLength-->0){
                next = head.next;
                head.next = newNode;
                newNode = head;
                head = next;
            }

            //反转结束
            modifyTail.next = head;

            if (preHead!=null){
                preHead.next = newNode;
            } else {
                res = newNode;
            }

            return res;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            ListNode head1 = new ListNode(2);
            head.next = head1;
             head1.next  = new ListNode(3);
             head1 = head1.next;
            head1.next = new ListNode(4);
            head1 = head1.next;
            head1.next = new ListNode(5);

            new Solution().reverseBetween(head, 3, 4);
        }
    }

}

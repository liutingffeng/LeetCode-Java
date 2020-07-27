package LCSolution;

import java.util.List;

public class LC234 {

    class Solution {
//        public boolean isPalindrome(ListNode head) {
//            if (head == null || head.next == null)
//                return true;
//            ListNode dummy = new ListNode(-1);
//            dummy.next = head;
//            ListNode slow = dummy;
//            ListNode fast = dummy;
//            ListNode pre = dummy;
//            int count = 0;
//            while (head!=null){
//                count++;
//                head = head.next;
//            }
//
//            while (fast!=null && fast.next !=null){
//                fast = fast.next.next;
//                pre = slow;
//                slow = slow.next;
//            }
//            ListNode right = slow.next;
//            if (count%2==1){
//                pre.next = null;
//            }
//            else {
//                slow.next = null;
//            }
//            ListNode left = reverse(dummy.next);
//            while (left!=null && right!=null){
//                if (left.val!=right.val)
//                    return false;
//                left = left.next;
//                right = right.next;
//            }
//            return true;
//
//        }
//
//        private ListNode reverse(ListNode node){
//            if (node == null || node.next == null)
//                return node;
//            ListNode pre = null;
//            ListNode next;
//            while (node!=null){
//                next = node.next;
//                node.next = pre;
//                pre = node;
//                node = next;
//            }
//            return pre;
//        }

        ListNode left ;
        public boolean isPalindrome(ListNode head) {
            left = head;
            return recusion(head);
        }

        private boolean recusion(ListNode right){
            if (right == null)
                return true;
            boolean res = recusion(right.next);
            res = res && (left.val == right.val);
            left = left.next;
            return res;
        }
    }


    public static void main(String[] args) {
//        Solution solution = new LC234().new Solution();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head = solution.reverse(head);
//
//        solution.isPalindrome(head);
    }
}

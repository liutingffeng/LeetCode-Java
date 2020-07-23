package LCSolution;

import org.junit.Test;

public class LC025 {

    static class Solution {
        //递归的话空间复杂度达不到要求
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k<=1)
                return head;
            ListNode end = head;
            int count = 0;
            while (end!=null){
                count++;
                if (count==k)
                    break;
                end = end.next;
            }
            //不用翻转
            if (count<k)
                return head;
            ListNode cur = head;
            // 翻转head-...end
            ListNode pre = null;
            end = end.next;
            while (head!=end){
                ListNode nex = head.next;
                head.next = pre;
                pre = head;
                head = nex;
            }
            cur.next = reverseKGroup(head, k);
            return pre;
        }

    }

    @Test
    public void t(){
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;

        new Solution().reverseKGroup(head, 2);
    }

}

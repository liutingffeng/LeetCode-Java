package LCSolution;

public class LC143 {

    class Solution {
        //递归
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return;
            //断掉最后一个节点
            ListNode tail = head;
            while (tail.next.next!=null)
                tail = tail.next;

            tail.next.next = head.next;
            head.next = tail.next;
            tail.next = null;
            reorderList(head.next.next);
        }

        //将链表分成两部分
        //反转后半部
//        再插入
    }
}

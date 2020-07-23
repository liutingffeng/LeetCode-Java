package LCSolution;

public class LC206 {

    class Solution {

        //递归
        // 1->2->3->4->5->NULL
        //输出: 5->4->3->2->1->NULL
//        public LCSolution.ListNode reverseList(LCSolution.ListNode head) {
//            if (head == null || head.next == null)
//                return head;
//
//            LCSolution.ListNode dummy = new LCSolution.ListNode(-1);
//            dummy.next = reverseList(head.next);
//            head.next.next = head;
//            head.next = null;
//            return dummy.next;
//        }

        //迭代
        //1->2->3->4->5->NULL
        //null<-1<-2<-3<-4<-5
//        public ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null)
//                return head;
//            ListNode cur = head;
//            ListNode pre = null;
//            ListNode next;
//            while (cur!=null){
//                next = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = next;
//            }
//            return pre;
//        }
//    }


    //迭代
    //1->2->3->4->5->NULL
    //null<-1<-2<-3<-4<-5
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    }
}

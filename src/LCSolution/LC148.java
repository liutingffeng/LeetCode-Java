package LCSolution;

public class LC148 {

    class Solution {
        //对链表进行排序，插入排序
//        public LCSolution.ListNode sortList(LCSolution.ListNode head) {
//            if (head == null)
//                return null;
//            LCSolution.ListNode dummy = new LCSolution.ListNode(Integer.MIN_VALUE);
//            dummy.next = head;
//            LCSolution.ListNode pre = head;
//            LCSolution.ListNode cur = head.next;
//            while (cur!=null){
//                if (cur.val>=pre.val){
//                    pre = cur;
//                    cur = cur.next;
//                    continue;
//                }
//                LCSolution.ListNode insPre = dummy;
//                while (insPre.next.val <= cur.val){
//                    insPre = insPre.next;
//                }
//                //开始插入
//                pre.next = cur.next;
//                cur.next = insPre.next;
//                insPre.next = cur;
//                cur = pre.next;
//            }
//            return dummy.next;
//        }

        //归并排序,递归的空间复杂度不满足要求
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            //快慢指针
            ListNode slow = dummy;
            ListNode fast = dummy;
            while (fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            fast = slow.next;
            slow.next = null;
            dummy.next = sortList(dummy.next);
            ListNode right = sortList(fast);
            return mergeTwoList(dummy.next,right);
        }


        private ListNode mergeTwoList(ListNode l1,ListNode l2){
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (l1!=null || l2!=null){
                if (l1 == null){
                    cur.next = l2;
                    break;
                }
                if (l2 == null){
                    cur.next = l1;
                    break;
                }
                if (l1.val>l2.val){
                    ListNode temp = l1;
                    l1 = l2;
                    l2 = temp;
                }
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
            }

            return dummy.next;
        }
    }
}

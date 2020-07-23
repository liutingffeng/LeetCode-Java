package LCSolution;

import java.util.PriorityQueue;

public class LC023 {

    class Solution {
//        public LCSolution.ListNode mergeKLists(LCSolution.ListNode[] lists) {
//            if (lists == null || lists.length == 0)
//                return null;
//            return merge(lists, 0, lists.length-1);
//        }
//
//        private LCSolution.ListNode merge(LCSolution.ListNode[] lists,int l,int r){
//            if (l == r){
//                return lists[l];
//            }
//            int mid = l+(r-l)/2;
//            LCSolution.ListNode lnode =  merge(lists, l,mid);
//            LCSolution.ListNode rnode = merge(lists, mid+1,r);
//            return mergeTwoLists(lnode, rnode);
//        }
//
//        private LCSolution.ListNode mergeTwoLists(LCSolution.ListNode l1, LCSolution.ListNode l2) {
//            if (l1 == null || l2 == null){
//                return l1 == null ? l2:l1;
//            }
//            if (l1.val>l2.val){
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
//            else {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            }
//        }

        //小顶堆
//        public ListNode mergeKLists(ListNode[] lists) {
//            if (lists == null || lists.length == 0)
//                return null;
//            ListNode dummy = new ListNode(0);
//            PriorityQueue<ListNode> pq = new PriorityQueue<>((o1,o2)->(o1.val-o2.val));
//            for (ListNode node : lists){
//                if (node != null){
//                    pq.add(node);
//                }
//            }
//
//            ListNode head = dummy;
//            while (!pq.isEmpty()){
//                ListNode cur = pq.poll();
//                head.next = cur;
//                head = head.next;
//                if (cur.next!=null){
//                    pq.add(cur.next);
//                }
//            }
//            return dummy.next;
//        }
//
//    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists,int l,int r){
        if (l>=r)
            return lists[l];

        int mid = l+(r-l)/2;
        ListNode llist = merge(lists, l, mid);
        ListNode rlist = merge(lists, mid+1, r);
        return merge2List(llist, rlist);
    }

    private ListNode merge2List(ListNode l1,ListNode l2){

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1!=null){
            cur.next = l1;
        }
        if (l2!=null){
            cur.next = l2;
        }
        return dummy.next;
    }


    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(4);
        pq.add(3);
        pq.add(2);
        pq.add(1);

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}

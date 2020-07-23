package LCSolution;

public class LC0142 {

    class Solution {
        public ListNode detectCycle(ListNode head){
            if (head == null)
                return null;

            ListNode fast = head;
            ListNode slow = head;
            boolean hasCycle = false;
            while (fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow){
                    hasCycle = true;
                    break;
                }
            }
            if (!hasCycle)
                return null;
            ListNode cyclePoint = head;

            while (cyclePoint!=slow){
                cyclePoint = cyclePoint.next;
                slow = slow.next;
            }
            return cyclePoint;

        }
    }
}

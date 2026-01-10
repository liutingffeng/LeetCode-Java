package LC2025;

import java.util.HashMap;
import java.util.Map;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class LC002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = l1;
        ListNode l1Pre = null;
        int addBit = 0;
        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            int sum = v1 + v2 + addBit;
            // 除数
            addBit = sum / 10;
            // 余数
            int y = sum % 10;
            // 当前的节点为 y
            l1.val = y;
            l1Pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) {
            if (addBit > 0) {
                l1Pre.next = new ListNode(addBit);
            }
            return pre;
        }
        // l2 没结束
        if (l1 == null) {
            l1Pre.next = l2;
        }
        if (addBit == 0)
            return pre;
        // 继续l1
        l1 = l1Pre.next;
        while (l1 != null) {
            int v1 = l1.val;
            int sum = v1 + addBit;
            // 除数
            addBit = sum / 10;
            // 余数
            int y = sum % 10;
            // 当前的节点为 y
            l1.val = y;
            l1Pre = l1;
            l1 = l1.next;
        }
        if (addBit > 0) {
            l1Pre.next = new ListNode(addBit);
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}

package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC382 {

    class Solution {
        ListNode head ;
        Random rand = new Random();
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int res = 0;
            int i =0;
            ListNode p = head;
            while (p != null){
                //
                if (rand.nextInt(++i) == 0){
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }
}

package LC2026;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239 {

    /**
     * 维护单调递减的双端队列（存下标）。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i + 1 >= k) {
                ans[i + 1 - k] = nums[dq.peekFirst()];
                // 队列头部超过范围了
                if ((i + 1 -k) >= dq.peekFirst()) {
                    dq.pollFirst();
                }
            }
        }
        return ans;
    }


}

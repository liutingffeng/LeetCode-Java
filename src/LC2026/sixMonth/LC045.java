package LC2026.sixMonth;

import LC2025.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC045 {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int step = 1;
        int maxLen = nums[0];
        int curEnd = maxLen;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + i > maxLen) {
                maxLen = nums[i] + i;
            }
            if (i == curEnd) {
                step++;
                curEnd = maxLen;
            }
        }
        return step;
    }
}

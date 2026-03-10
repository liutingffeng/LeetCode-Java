package LC2026;

import java.util.PriorityQueue;

public class LC198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre_1 = nums[0];
        int pre = Math.max(pre_1, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int curmax = Math.max(pre_1 + nums[i], pre);
            pre_1 = pre;
            pre = curmax;
        }
        return pre;
    }

}

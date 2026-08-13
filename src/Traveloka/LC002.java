package Traveloka;

import java.util.Arrays;

/**
 * @Author liutingfeng
 * @Date 2026/7/31 16:40
 */
public class LC002 {

    /**
     * 给定整数数组 nums，求其中最长严格递增子序列的长度。子序列需要保持原数组中的相对顺序，可以跳过部分元素。
     * 输入：
     * [10, 9, 2, 5, 3, 7, 101, 18]
     *
     * 输出：
     * 4
     * 其中一个最长递增子序列：
     * [2, 3, 7, 101]
     */

    public static int lengthOfLIS(int[] nums) {
        // 边界：空数组没有子序列，长度为 0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 每个 i 的内层循环结束后统一更新结果，不依赖 if 是否命中
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int result = lengthOfLIS(
                new int[]{10, 9, 2, 5, 3, 7, 101, 18}
        );

        System.out.println(result); // 4
    }
}

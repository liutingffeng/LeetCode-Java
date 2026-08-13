package Traveloka;

/**
 * @Author liutingfeng
 * @Date 2026/7/31 17:35
 */
public class LC005 {

    /**
     * 给定一个正整数数组 nums，判断能否将数组分成两个子集，使两个子集的元素之和相等。
     * 输入：
     * [1, 5, 11, 5]
     *
     * 输出：
     * true
     * 一种分割方式：
     * [1, 5, 5] 和 [11]
     * 两个子集的元素之和都是 11。
     */

    public static boolean canPartition(int[] nums) {
        int total = 0;

        for (int number : nums) {
            total += number;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        boolean result = canPartition(
                new int[]{1, 5, 11, 3}
        );

        System.out.println(result); // true
    }
}

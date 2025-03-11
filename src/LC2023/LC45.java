package LC2023;

public class LC45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (dp[i] == -1)
                continue;
            int v = nums[i];
            int origin = dp[i];
            if (i + v >= (nums.length - 1))
                return origin + 1;
            for (int j = i; j <= (i + v) && j < nums.length; j++) {
                if (dp[j] == -1) {
                    dp[j] = origin + 1;
                } else {
                    dp[j] = Math.min(dp[j], origin + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new LC45().jump(nums);
    }
}

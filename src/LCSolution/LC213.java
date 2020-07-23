package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC213 {

    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int res = 0;
            if (nums.length == 1)
                return nums[0];
            //不考虑最后一个间
            int[] dp = new int[nums.length];
            dp[1] = nums[0];
            for (int i=2;i<nums.length;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
            }
            res = dp[nums.length-1];
            //不考虑第一间
            dp[1] = nums[1];
            for (int i=3;i<=nums.length;i++){
                dp[i-1] = Math.max(dp[i-2],dp[i-3]+nums[i-1]);
            }
            return Math.max(res, dp[nums.length-1]);
        }
    }
}

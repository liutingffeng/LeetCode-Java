package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC416 {

    class Solution {
//        public boolean canPartition(int[] nums) {
//            int sum = 0;
//            for (int num:nums)
//                sum +=num;
//            return helper(nums, sum/2.0, 0);
//        }
//
//        public boolean helper(int[] nums,double sum,int index){
//            if (sum == 0)
//                return true;
//            if (sum<0)
//                return false;
//
//            for (int i=index;i<nums.length;i++){
//                if (helper(nums, sum-nums[i],i+1))
//                    return true;
//            }
//            return false;
//        }

//        public boolean canPartition(int[] nums) {
//            int sum = 0;
//            for (int num:nums)
//                sum +=num;
//            if ((sum&1) == 1)
//                return false;
//            int parValue = sum/2;
//            boolean[] dp = new boolean[parValue+1];
//            dp[0] = true;
//
//            if (nums[0]<=parValue)
//                dp[nums[0]] = true;
//
//            for (int i=1;i<nums.length;i++){
//                for (int j=parValue;j>=nums[i];j--){
//                    dp[j] = dp[j] || dp[j-nums[i]];
//                }
//                if (dp[parValue])
//                    return true;
//            }
//
//            return dp[parValue];
//        }

        // 2020 07 24
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums)
                sum += num;

            if (sum % 2 ==1)
                return false;

            int target = sum /2;
            // 从nums 中选出和为target 的子集
            boolean[] dp = new boolean[target+1];
            dp[0] = true;
            for (int i = 0; i < nums.length; i++) {
                for (int j = target; j >= nums[i] ; j--) {
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
                if (dp[target])
                    return true;
            }

            return dp[target];
        }
    }
}

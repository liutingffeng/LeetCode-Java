package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC376 {

    class Solution {

        /*
        dp[i][0]表示从nums[0]到nums[i]的最长摆动序列长度，且nums[i] < nums[i - 1]，
        dp[i][1]表示从nums[0]到nums[i]的最长摆动序列长度，且nums[i] > nums[i - 1 ]。
         */
//        public int wiggleMaxLength(int[] nums) {
//            if (nums.length <=1)
//                return nums.length;
//            int n = nums.length;
//            int[] dp = new int[n];
//            dp[0] = 1;
//            dp[1] = nums[1]==nums[0]? 1:2;
//            for (int i=2;i<n;i++){
//                dp[i] = dp[i-1];
//                if ((nums[i]>nums[i-1])){
//                    //找到前面
//                    int j = i-1;
//                    while (j>=0 && nums[j]<=nums[j+1])
//                        j--;
//                    if (j>=0)
//                        dp[i] = dp[j+1]+1;
//                }
//                if (nums[i]<nums[i-1]){
//                    int j = i-1;
//                    while (j>=0 && nums[j]>=nums[j+1])
//                        j--;
//                    if (j>=0)
//                        dp[i] = dp[j+1]+1;
//                }
//            }
//            return dp[n-1];
//        }


        public int wiggleMaxLength(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int up = 1, down = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]>nums[i-1]){
                    up = down+1;
                }
                else if (nums[i]<nums[i-1]){
                    down = up + 1;
                }
            }

            return Math.max(up, down);
        }
    }
}

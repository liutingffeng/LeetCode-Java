package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC494 {

    class Solution {
//        private int count;
//        public int findTargetSumWays(int[] nums, int S) {
//            dfs_helper(nums,0,S);
//            return count;
//        }
//
//        public void dfs_helper(int[] nums,int index,int s){
//            if (index>=nums.length){
//                if (s == 0){
//                    count++;
//                }
//                return;
//            }
//
//            dfs_helper(nums, index+1,s+nums[index] );
//            dfs_helper(nums, index+1, s-nums[index]);
//        }

        /*
        我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]

那么让我们看看如何将其转换为子集求和问题：

                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
因此，原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，使得sum(P) = (target + sum(nums)) / 2
         */

        // 0-1背包问题
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int num:nums)
                sum+=num;
            if (sum<S || (sum+S)%2 == 1)
                return 0;

            int w = (S + sum)>>1;
            int[] dp = new int[w+1];
            dp[0] = 1;  // 和为0 的取法
            for (int num:nums){
                for (int j=w;j>=num;j--)
                    dp[j] = dp[j]+dp[j-num];
            }
            return dp[w];
        }

    }
}

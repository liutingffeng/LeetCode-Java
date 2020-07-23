package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC312 {

    class Solution {

        //你不是要最后戳破气球 k 吗？那得先把开区间 (i, k) 的气球都戳破，再把开区间 (k, j) 的气球都戳破；最后剩下的气球 k，相邻的就是气球 i 和气球 j，这时候戳破 k 的话得到的分数就是 points[i]*points[k]*points[j]。
        //
        //那么戳破开区间 (i, k) 和开区间 (k, j) 的气球最多能得到的分数是多少呢？嘿嘿，就是 dp[i][k] 和 dp[k][j]，这恰好就是我们对 dp 数组的定义嘛！
        //

        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] newNums = new int[nums.length+2];
            newNums[0] = 1;
            newNums[n+1] = 1;
            for (int i=1;i<=n;i++)
                newNums[i] = nums[i-1];

            //  dp[i,j] (i,j)内能获得的最大硬币数[0,n+1]
            int[][] dp = new int[n+2][n+2];
            //i 从下往上
            for (int i=n;i>=0;i--){
                //j 从左往右
                for (int j=i+1;j<n+2;j++){
                    //最后戳破的是哪个气球
                    for (int k=i+1;k<j;k++){
                        //择优
                        dp[i][j] = Math.max(dp[i][j],dp[i][k]+dp[k][j]+newNums[i]*newNums[k]*newNums[j]);
                    }
                }
            }
            return dp[0][n+1];

        }
    }
}

package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC309 {

    class Solution {
        public int maxProfit(int[] prices) {
            int dp0 = 0;
            int dp1 = Integer.MIN_VALUE;
            int pre0 = 0; // dp[i-2][0]
            for (int i=0;i<prices.length;i++){
                int temp = dp0;
                dp0 = Math.max(dp0, dp1+prices[i]);
                dp1 = Math.max(dp1, pre0-prices[i]);
                pre0 = temp;
            }
            return dp0;
        }
    }
}

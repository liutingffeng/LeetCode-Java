package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC121 {

    class Solution {
//        public int maxProfit(int[] prices) {
//            if (prices == null || prices.length == 0)
//                return 0;
//            int res = 0;
//            int minValue = Integer.MAX_VALUE;
//            for (int i=0;i<prices.length;i++){
//                if (prices[i] > minValue){
//                    res = Math.max(res, prices[i]-minValue);
//                }
//                else {
//                    minValue = prices[i];
//                }
//            }
//            return res;
//        }

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;
            int n = prices.length;

//            for (int i = 0; i < n; i++) {
//                if (i == 0){
//                    dp[i][1] = -prices[i];
//                    continue;
//                }
//                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
//            }

            int  dpi0 = 0, dpi1 = -prices[0];
            for (int i = 1; i < n; i++) {
                dpi0 = Math.max(dpi0, dpi1+prices[i]);
                dpi1 = Math.max(dpi1, -prices[i]);
            }

            return dpi0;
        }
    }
}

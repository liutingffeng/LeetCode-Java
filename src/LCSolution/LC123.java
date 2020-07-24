package LCSolution;

public class LC123 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;
            int n = prices.length;

            int dpi10 = 0, dpi11 = -prices[0];
            int dpi20 = 0, dpi21 = -prices[0];
            for (int i = 1; i < n; i++) {
                dpi20 = Math.max(dpi20, dpi21+prices[i]);
                dpi21 = Math.max(dpi21, dpi10-prices[i]);
                dpi10 = Math.max(dpi10, dpi11+prices[i]);
                dpi11 = Math.max(dpi11, -prices[i]);
            }

            return dpi20;
        }
    }
}

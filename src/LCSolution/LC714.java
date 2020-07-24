package LCSolution;

public class LC714 {

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0)
                return 0;
            int n = prices.length;

            int  dpi0 = 0, dpi1 = -prices[0]-fee;
            for (int i = 1; i < n; i++) {
                int temp = dpi0;
                dpi0 = Math.max(dpi0, dpi1+prices[i]);
                dpi1 = Math.max(dpi1, temp-prices[i]-fee);
            }

            return dpi0;
        }
    }
}

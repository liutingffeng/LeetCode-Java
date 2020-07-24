package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC122 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;
            int n = prices.length;

            int  dpi0 = 0, dpi1 = -prices[0];
            for (int i = 1; i < n; i++) {
                int temp = dpi0;
                dpi0 = Math.max(dpi0, dpi1+prices[i]);
                dpi1 = Math.max(dpi1, dpi0-prices[i]);
            }

            return dpi0;
        }
    }
}

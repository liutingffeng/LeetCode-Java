package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC121 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;
            int res = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i=0;i<prices.length;i++){
                if (prices[i] > minValue){
                    res = Math.max(res, prices[i]-minValue);
                }
                else {
                    minValue = prices[i];
                }
            }
            return res;
        }
    }
}

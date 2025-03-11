package LC2023;

public class LC121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length < 2)
            return res;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            if (cur > min)
                res = Math.max(res, cur - min);
            if (cur < min)
                min = cur;
        }
        return res;
    }
}

package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC518 {

    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount+1];
            dp[0] = 1;
            for (int coin : coins){
                for (int i = 0;i<=amount;i++) {
                    dp[i] += i>= coin ? dp[i-coin]:0;
                }
            }
            return dp[amount];
        }
    }
}

package LCSolution;

import java.util.*;

public class LC322 {

    class Solution {
//        public int coinChange(int[] coins, int amount) {
//            return dfs(coins, amount);
//        }
//
//        private int dfs(int[] coins,int amount){
//            if (amount < 0)
//                return -1;
//            if (amount == 0)
//                return 0;
//
//            int res = Integer.MAX_VALUE;
//            for (int coin:coins){
//                int rValue = dfs(coins, amount-coin);
//                if (rValue!=-1)
//                    res = Math.min(res, 1+rValue);
//            }
//            if (res == Integer.MAX_VALUE)
//                return -1;
//            else
//                return res;
//        }

        public int coinChange(int[] coins, int amount) {

//            Set<Integer> set = new HashSet<>();
//            for (int coin:coins){
//                set.add(coin);
//            }
            int[] dp = new int[amount+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i=0;i<amount+1;i++){
                for (int coin:coins){
                    int pre = i-coin;
                    if (pre>=0 && dp[pre]!=-1){
                        dp[i] = Math.min(dp[i],1+dp[pre]);
                    }
                }
                if (dp[i] == Integer.MAX_VALUE)
                    dp[i] = -1;
            }
            return dp[amount];
        }
    }
}

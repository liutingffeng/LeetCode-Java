package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC877 {

    class Pair{
        int first;
        int last;
        public Pair(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }


    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            Pair[][] dp= new Pair[n][n];
            //
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = new Pair(0, 0);
                }
            }

            for (int i = n-1; i >=0 ; i--) {
                for (int j = i; j <n ; j++) {
                    if (i == j){
                        dp[i][j].first = piles[i];
                        continue;
                    }
                    int left = piles[i]+dp[i+1][j].last;
                    int right = piles[j]+dp[i][j-1].last;
                    if (left>right){
                        dp[i][j].first = left;
                        dp[i][j].last = dp[i+1][j].first;
                    }
                    else {
                        dp[i][j].first = right;
                        dp[i][j].last = dp[i][j-1].first;
                    }
                }
            }

            System.out.println(dp[0][n-1].first+" "+dp[0][n-1].last);
            return dp[0][n-1].first>dp[0][n-1].last;
        }
    }

    public static void main(String[] args) {
        new LC877().new Solution().stoneGame(new int[]{5,3,4,5});
    }
}

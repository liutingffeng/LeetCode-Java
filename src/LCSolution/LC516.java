package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC516 {

    class Solution {
        public int longestPalindromeSubseq(String s) {
            char[] charArray = s.toCharArray();
            int n = charArray.length;
            int[][] dp = new int[n][n];

            for (int i = n-1; i >=0; i--) {
                for (int j = i; j < n; j++) {
                    if (i == j){
                        dp[i][j] = 1;
                        continue;
                    }
                    if (charArray[i] == charArray[j]){
                        if (j-i<2)
                            dp[i][j] = 2;
                        else {
                            dp[i][j] = dp[i+1][j-1]+2;
                        }
                    }
                    else {
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
            return dp[0][n-1];
        }
    }
}

package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC474 {

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {

            int[][] dp = new int[m+1][n+1];
            for (String str:strs){
                int[] count = countOneOrZero(str);
                for (int i=m;i>=count[0];i--){
                    for (int j=n;j>=count[1];j--){
                        dp[i][j] = Math.max(dp[i][j],dp[i-count[0]][j-count[1]]+1);
                    }
                }
            }
            return dp[m][n];
        }

        private int[] countOneOrZero(String str){
            int[] res = new int[2];
            for (char c:str.toCharArray()){
                res[c-'0']++;
            }
            return res;
        }
    }
}

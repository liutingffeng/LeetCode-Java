package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC072 {

    class Solution {
        //动态规划
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word1.length();

            char[] word1Char = word1.toCharArray();
            char[] word2Char = word2.toCharArray();

            int[][] memo = new int[m+1][n+1];

            for (int i=0;i<=n;i++){
                //0 -> i 需要几步
                memo[0][i] = i;
            }
            for (int i=0;i<=m;i++){
                //i -> 0 需要几步
                memo[m][0] = i;
            }

            for (int i=1;i<m;i++){
                for (int j=1;j<n;j++){
                    //从i个字符 ---> j个字符需要多少步
                    if (word1Char[i-1] != word2Char[j-1]){
                        memo[i][j] = 1+Math.min(memo[i-1][j-1],Math.min(memo[i-1][j],memo[i][j-1]));
                    }
                    else {
                        memo[i][j] = memo[i-1][j-1];
                    }
                }
            }
            return memo[m][n];
        }
    }
}

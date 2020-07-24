package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC072 {

    class Solution {
        //动态规划
//        public int minDistance(String word1, String word2) {
//            int m = word1.length();
//            int n = word1.length();
//
//            char[] word1Char = word1.toCharArray();
//            char[] word2Char = word2.toCharArray();
//
//            int[][] memo = new int[m+1][n+1];
//
//            for (int i=0;i<=n;i++){
//                //0 -> i 需要几步
//                memo[0][i] = i;
//            }
//            for (int i=0;i<=m;i++){
//                //i -> 0 需要几步
//                memo[m][0] = i;
//            }
//
//            for (int i=1;i<m;i++){
//                for (int j=1;j<n;j++){
//                    //从i个字符 ---> j个字符需要多少步
//                    if (word1Char[i-1] != word2Char[j-1]){
//                        memo[i][j] = 1+Math.min(memo[i-1][j-1],Math.min(memo[i-1][j],memo[i][j-1]));
//                    }
//                    else {
//                        memo[i][j] = memo[i-1][j-1];
//                    }
//                }
//            }
//            return memo[m][n];
//        }


        //word1 = "horse", word2 = "ros"
        public int minDistance(String word1, String word2) {
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            int m = chars1.length;
            int n = chars2.length;

            int[] lastdp = new int[n+1];
            // "" -> "ros"
             for (int i = 1; i <= n; i++) {
                lastdp[i] = i;
            }

             int[] curdp = new int[n+1];
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j <=n; j++) {
                    if (j==0){
                        curdp[j] = i;
                    }
                    else {
                        if (chars1[i-1] == chars2[j-1]){
                            curdp[j] = lastdp[j-1];
                        }
                        else {
                            curdp[j] = Math.min(curdp[j-1],Math.min(lastdp[j],lastdp[j-1]))+1;
                        }
                    }
                }
                int[] temp = lastdp;
                lastdp = curdp;
                curdp = temp;
            }

            return lastdp[n];
        }
    }
}

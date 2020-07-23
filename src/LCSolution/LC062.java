package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC062 {

    class Solution {
//        public int uniquePaths(int m, int n) {
//            int[][] memo = new int[m][n];
//            for (int i=1;i<n;i++)
//                memo[0][i] = 1;
//            for (int i=1;i<m;i++)
//                memo[i][0] = 1;
//            for (int i=1;i<m;i++)
//                for (int j=1;j<n;j++){
//                    memo[i][j] = memo[i][j-1]+memo[i-1][j];
//                }
//
//            return memo[m-1][n-1];
//        }

        //降低空间复杂度
        public int uniquePaths(int m, int n) {

            int[] memo = new int[n];
            for (int i=0;i<n;i++)
                memo[i] = 1;
            for (int i=1;i<m;i++)
                for (int j=1;j<n;j++){
                    memo[j] = memo[j-1]+memo[j];
                }
            return memo[n-1];
        }
    }
}

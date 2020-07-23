package LCSolution;

public class LC221 {

    class Solution {

        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int maxEdge = 0;
            int[][] dp = new int[m][n];

            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    if (matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    }
                    else {
                        if (i==0 || j==0)
                            dp[i][j] = 1;
                        else
                            dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    }
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
            return maxEdge*maxEdge;
        }

    }

    public static void main(String[] args) {
        Solution solution = new LC221().new Solution();
        int[] arr = new int[]{1};

    }
}

package LCSolution;

public class LC221 {

    class Solution {

//        public int maximalSquare(char[][] matrix) {
//            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//                return 0;
//            int m = matrix.length;
//            int n = matrix[0].length;
//            int maxEdge = 0;
//            int[][] dp = new int[m][n];
//
//            for (int i=0;i<m;i++){
//                for (int j=0;j<n;j++){
//                    if (matrix[i][j] == '0'){
//                        dp[i][j] = 0;
//                    }
//                    else {
//                        if (i==0 || j==0)
//                            dp[i][j] = 1;
//                        else
//                            dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
//                    }
//                    maxEdge = Math.max(maxEdge, dp[i][j]);
//                }
//            }
//            return maxEdge*maxEdge;
//        }


        public int maximalSquare(char[][] matrix) {
            if (matrix.length==0 || matrix[0].length == 0)
                return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            // dp存储的是当前正方形的右下顶点
            int[] lastdp = new int[n];
            int[] curdp = new int[n];
            int maxEdge = 0;
            //初始化
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == '1'){
                    lastdp[i] = 1;
                    maxEdge = 1;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0){
                        curdp[j] = matrix[i][j] == '1'? 1 : 0;
                    }
                    else {
                        curdp[j] = matrix[i][j] == '0' ? 0 : Math.min(curdp[j-1],Math.min(lastdp[j-1],lastdp[j]))+1;
                    }
                    maxEdge = Math.max(maxEdge, curdp[j]);
                }
                // 交换
                int[] temp = lastdp;
                lastdp = curdp;
                curdp = temp;
            }

            return maxEdge*maxEdge;
        }

    }

    public static void main(String[] args) {
        Solution solution = new LC221().new Solution();
        int[] arr = new int[]{1};

    }
}

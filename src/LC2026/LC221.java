package LC2026;

/**
 * LC221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 动态规划：
 *   dp[i][j] = 以 matrix[i][j] 为右下角的最大正方形边长
 *   转移方程：若 matrix[i][j] == '1'
 *     dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
 *   边界：i==0 或 j==0 时，dp[i][j] = matrix[i][j] - '0'
 *   答案：max(dp[i][j])^2
 */
public class LC221 {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 边界：只能构成 1×1 的正方形
                        dp[i][j] = 1;
                    } else {
                        // 木桶效应：取左、上、左上三个方向的最小值 + 1
                        dp[i][j] = Math.min(dp[i - 1][j],
                                   Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
                // matrix[i][j] == '0' 时 dp[i][j] 默认为 0，无需处理
            }
        }

        return maxSide * maxSide;
    }

}

package LC2026;


public class LC72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] 表示将 word1[0:i) 转换为 word2[0:j) 的最少操作数
        int[][] dp = new int[m + 1][n + 1];

        // base case: 将空字符串变为 word2[0:j) 需要 j 次插入
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // base case: 将 word1[0:i) 变为空字符串需要 i 次删除
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 字符相同，无需操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 取三种操作的最小值 + 1
                    dp[i][j] = 1 + Math.min(
                        Math.min(dp[i - 1][j], dp[i][j - 1]),  // 删除或插入
                        dp[i - 1][j - 1]                        // 替换
                    );
                }
            }
        }

        return dp[m][n];
    }

}

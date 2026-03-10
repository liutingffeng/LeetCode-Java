package LC2026;

import java.util.List;

public class LC120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> curRow = triangle.get(i);
            for (int j = (curRow.size() - 1); j >= 0; j--) {
                if (i == 0) {
                    dp[j] = curRow.get(j);
                } else if (j == curRow.size() - 1) {
                    dp[j] = dp[j-1] + curRow.get(j);
                } else if (j == 0) {
                    dp[j] += curRow.get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + curRow.get(j);
                }
            }
        }
        int res = dp[0];
        for (int num : dp) {
            res = Math.min(res, num);
        }
        return res;
    }

}

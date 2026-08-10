package LC2026.sixMonth;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC131 {
    /**
     * 预处理 dp[i][j] 表示 s[i..j] 是否为回文串。
     * 回溯时从当前位置枚举所有回文子串，加入路径后递归处理剩余部分。
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, dp, res, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int start, boolean[][] dp, List<List<String>> res, List<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, dp, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
}

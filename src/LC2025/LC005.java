package LC2025;

public class LC005 {

    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        int length = s.length();
        /**
         * babad
         * 1
         *  1
         *   1
         *    1
         *     1
         */
        // 动态规划
        boolean[][] dp = new boolean[length][length];
        String maxSubStr = "";

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    if ((j - i + 1) > maxSubStr.length()) {
                        maxSubStr = s.substring(i, j+1);
                    }
                } else {
                    char lc = s.charAt(i);
                    char rc = s.charAt(j);
                    if (lc == rc) {
                        if (j - i == 1 || dp[i+1][j-1]) {
                            dp[i][j] = true;
                            if ((j - i + 1) > maxSubStr.length()) {
                                maxSubStr = s.substring(i, j+1);
                            }
                        }
                    }
                }
            }
        }
        return maxSubStr;
    }
}

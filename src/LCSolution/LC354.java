package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC354 {

    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0)
                return 0;
            Arrays.sort(envelopes,(o1,o2)->o1[0] == o2[0]? o2[1]-o1[1]:o1[0]-o2[0]);
            int m = envelopes.length;

            int[] height = new int[m];
            for (int i = 0; i < m; i++) {
                height[i] = envelopes[i][1];
            }

            int[] dp = new int[m];
            int res = 1;
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j=0;j<i;j++){
                    if (height[i]>height[j])
                        dp[i] = Math.max(dp[j]+1,dp[i]);
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}

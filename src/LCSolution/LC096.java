package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC096 {

    class Solution {
        // 优化，不用判断是否为0，直接记录memo[0]=1;
        public int numTrees(int n) {
            if (n<1)
                return 0;
            int[] memo = new int[n+1];
            memo[1] = 1;
            memo[0] = 1;
            for (int i = 2; i <=n; i++) {
                for (int j = 1; j <=i; j++) {
                    memo[i] += memo[j-1]*memo[i-j];
                }
            }
            return memo[n];
        }
    }
}

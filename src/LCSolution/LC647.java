package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC647 {

    class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0)
                return 0;

            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int res = 0;
            char[] array = s.toCharArray();
            for (int i=n-1;i>=0;i--){
                for (int j=i;j<n;j++){
                    if (array[i] == array[j] && ((j-i <=1) ||dp[i+1][j-1])){
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
            return res;
        }
    }
}

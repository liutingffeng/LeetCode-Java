package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC1143 {

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();
            int m = chars1.length;
            int n = chars2.length;

            int[] lastdp = new int[n+1];
            int[] curdp = new int[n+1];

            for (int i = 1; i <=m ; i++) {
                for (int j = 1; j <=n; j++) {
                    if (chars1[i-1] == chars2[j-1]){
                        curdp[j] = lastdp[j-1]+1;
                    }
                    else {
                        curdp[j] = Math.max(curdp[j-1], lastdp[j]);
                    }
                }

                int[] temp = lastdp;
                lastdp = curdp;
                curdp = temp;
            }

            return lastdp[n];
        }
    }
}

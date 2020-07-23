package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC095 {

    class Solution {
//        public int numTrees(int n) {
//            if (n==1 || n==0)
//                return 1;
//
//            int res = 0;
//            for (int i=1;i<=n;i++){
//                res += numTrees(i-1)*numTrees(n-i);
//            }
//            return res;
//        }

        public int numTrees(int n) {
            int[] memo = new int[n+1];
            memo[0] = 1;
            memo[1] = 1;
            for (int i=2;i<=n;i++)
                for (int j=1;j<=i;j++){
                    memo[i] += memo[j-1]*memo[i-j];
                }
            return memo[n];
        }


    }
}

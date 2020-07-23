package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC070 {

    class Solution {
        //f(n) = f(n-1)+f(n-2)
        public int climbStairs(int n) {
            if (n<=1)
                return 1;
            if (n == 2)
                return 2;
            int fn1 = 2;
            int fn2 = 1;
            int res = 0;
            for (int i=3;i<=n;i++){
                res = fn1+fn2;
                fn2 = fn1;
                fn1 = res;
            }
            return res;

        }
    }
}

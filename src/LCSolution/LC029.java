package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC029 {

    class Solution {
        public int divide(int dividend, int divisor) {
            boolean negative = false;

            if (dividend == Integer.MIN_VALUE && divisor == -1){
                return Integer.MAX_VALUE;
            }
            // 异或来计算符号
            negative = (dividend^divisor)<0;
            long t = Math.abs((long) dividend);
            long d= Math.abs((long) divisor);
            int result = 0;
            for (int i = 31; i >=0 ; i--) {
                if (t>>i>=d){  // 找出 2*n*divisor
                    result += 1<<i;  // 将结果加上 2^n
                    t -= d<<i;   // 将被除数减去2^n*divisor
                }
            }

            return negative ? -result:result;
        }
    }

}

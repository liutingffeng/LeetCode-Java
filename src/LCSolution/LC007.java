package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC007 {

    class Solution {
        public int reverse(int x) {
            int ans = 0;

            while (x!=0){
                int pop = x%10;
                if (ans > Integer.MAX_VALUE/10 ||(ans == Integer.MAX_VALUE/10 && pop>7))
                    return 0;
                if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && pop < -8))
                    return 0;
                ans = ans*10+pop;
                x = x/10;
            }
            return ans;
        }
    }
}

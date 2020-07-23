package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC509 {

    class Solution {
        public int fib(int N) {
            if (N<=1)
                return N;

            int fn_2 = 0;
            int fn_1 = 1;
            for (int i=2;i<=N;i++){
                int temp = fn_1;
                fn_1 = fn_1+fn_2;
                fn_2 = temp;
            }
            return fn_1;
        }
    }
}

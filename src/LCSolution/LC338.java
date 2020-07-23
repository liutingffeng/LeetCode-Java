package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC338 {

    class Solution {
        /*
        i >> 1会把最低位去掉，因此i >> 1 也是比i小的，同样也是在前面的数组里算过。
        当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；当i的最低位是1，
        i 中1的个数是 i >> 1中1的个数再加1
         */
        public int[] countBits(int num) {
            int[] res = new int[num+1];
            for (int i=1;i<=num;i++){
                res[i] = res[i>>1]+(i&1);
            }
            return res;
        }
    }
}

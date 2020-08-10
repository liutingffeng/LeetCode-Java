package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz014II {

    class Solution {
        public int cuttingRope(int n) {
            if (n<4)
                return n-1;
            long res = 1;
            // 模数
            int p = (int) (1e9+7);
            // 循环求余， 贪心算法
            while (n>4){
                res = res*3%p;
                n -=3;
            }

            // 跳出循环 n = 2, 3 ,4
            return (int) ((res*n)%p);
        }
    }
}

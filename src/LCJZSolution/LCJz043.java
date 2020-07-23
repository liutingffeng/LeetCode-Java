package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz043 {

    class Solution {
        public int countDigitOne(int n) {
            int digit = 1;  //个位
            int res = 0;
            int high = n/10;  //高位
            int cur = n%10;   //当前数字
            int low = 0;     //地位
            //当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
            while (high!=0 || cur!=0){
                //当前位为0
                if (cur == 0){
                    res += high*digit;
                }
                else if (cur == 1){
                    res += high*digit+low+1;
                }
                // 2-9
                else {
                    res += (high+1)*digit;
                }
                //将 cur 加入 low ，组成下轮 low
                low = cur*digit+low;
                cur = high%10;  //下轮 cur 是本轮 high 的最低位
                high /=10;  //将本轮 high 最低位删除，得到下轮 high
                digit *=10;  //位因子每轮 × 10
            }
            return res;
        }
    }
}

package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz042 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int res = Integer.MIN_VALUE;
            int preSum = -1;
            for (int num :nums){
                preSum = preSum<0 ? num : preSum+num ;
                res = Math.max(res, preSum);
            }
            return res;
        }
    }
}

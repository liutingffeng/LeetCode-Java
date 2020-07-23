package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC053 {

    class Solution {
        //动态规划
//        public int maxSubArray(int[] nums) {
//            int res = nums[0];
//            int sum = 0;
//            for (int cur:nums){
//                if (sum>0){
//                    sum+=cur;
//                }
//                else {
//                    sum = cur;
//                }
//            }
//            return res;
//        }

        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int sum = 0;
            for (int num:nums){
                if (sum > 0)
                    sum +=num;
                else
                    sum = num;
                res = Math.max(res, sum);
            }
            return res;
        }
    }
}

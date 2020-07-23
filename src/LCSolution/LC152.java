package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC152 {

    class Solution {
        //[2,3,-2,4]
        public int maxProduct(int[] nums) {
            int res = Integer.MIN_VALUE;
            int maxValue = 1;
            int minValue = 1;

            for (int num:nums){
                //将左边的最大值和最小值交换
                if (num<0){
                    int temp = maxValue;
                    maxValue = minValue;
                    minValue = temp;
                }
                maxValue = maxValue*num > num? maxValue*num:num;
                minValue = minValue*num < num? minValue*num:num;
                res = Math.max(res, maxValue);
            }
            return res;
        }
    }
}

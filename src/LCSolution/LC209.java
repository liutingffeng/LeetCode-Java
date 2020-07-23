package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC209 {

    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int res = nums.length;
            int sum = 0;
            int l = 0;
            int r = 0;
            while (r<nums.length){
                sum +=nums[r];
                r++;

                while (sum >= s){
                    res = Math.min(res, r-l);
                    sum -= nums[l];
                    l++;
                }
            }
            return res == nums.length ? 0:res;
        }


        // 前缀和+ 二分查找
    }
}

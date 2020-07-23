package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC136 {

    class Solution {
        //异或，相同为0，不同为1
        public int singleNumber(int[] nums) {
            int res = nums[0];

            for (int i=1;i<nums.length;i++)
                res = res^nums[i];
            return res;
        }
    }
}

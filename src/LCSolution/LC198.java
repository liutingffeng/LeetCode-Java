package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC198 {

    class Solution {
        public int rob(int[] nums) {
            int[] memo = new int[nums.length+1];
            if (nums.length == 0)
                return 0;
            memo[1] = nums[0];
            for (int i=2;i<=nums.length;i++){
                memo[i] = Math.max(memo[i-1],memo[i-2]+nums[i-1]);
            }
            return memo[nums.length];
        }
    }
}

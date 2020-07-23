package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC026 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int n = nums.length;
            int l = 1;  // [0,l)
            int r = 1;
            while (r<n){
                if (nums[r]!=nums[r-1])
                    nums[l++] = nums[r];
                r++;
            }
            return l;
        }
    }
}

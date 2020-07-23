package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC027 {

    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0)
                return 0;
            int n = nums.length;
            int l = 0;  // [0,l)
            int r = 0;
            while (r<n){
                if (nums[r] != val){
                    nums[l++] = nums[r];
                }
                r++;
            }
            return l;
        }
    }
}

package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC283 {

    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0)
                return;
            int n = nums.length;
            int l = 0;
            int r = 0;
            while (r<n){
                if (nums[r]!=0){
                    nums[l] = nums[r];
                    l++;
                }
                r++;
            }
            while (l<n){
                nums[l++] = 0;
            }
            return;
        }
    }
}

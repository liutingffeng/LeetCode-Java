package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC080 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int n = nums.length;
            int l = 1;  // [0,l)
            int r = 1;
            int count = 1;
            while (r<n){
                if (nums[r] == nums[r-1]){
                    count++;
                }
                else{
                    count = 1;
                }
                if (count<=2)
                    nums[l++] = nums[r];
                r++;
            }
            return l;
        }
    }
}

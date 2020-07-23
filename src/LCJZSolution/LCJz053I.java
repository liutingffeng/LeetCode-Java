package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz053I {

    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return 0;
            int l = 0 ,r = nums.length-1;
            while (l<=r){
                int mid = l+(r-l)/2;

                if (nums[mid] == target){
                    r = mid-1;
                }
                else if (nums[mid]>target){
                    r = mid-1;
                }
                else {
                    l = mid + 1;
                }
            }
            int res = 0;
            while (++r < nums.length){
                if (nums[r]!=target)
                    break;
                res++;
            }
            return res;
        }
    }
}

package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz053II {

    class Solution {
        public int missingNumber(int[] nums) {
            int l=0 , r= nums.length-1;
            while (l<r){
                int mid = l+(r-l)/2;
                if (nums[mid] == mid)
                    l = mid+1;
                else
                    r = mid;
            }
            return l == nums[l] ? nums.length:l;
        }
    }
}

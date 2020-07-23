package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC448 {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int num:nums){
                nums[Math.abs(num) - 1] = -Math.abs(nums[Math.abs(num) - 1]);

            }

            for (int i=0;i<nums.length;i++)
                if (nums[i]>0)
                    res.add(i+1);

            return res;
        }
    }
}

package LCJZSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCJz045 {

    class Solution {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i=0;i<nums.length;i++)
                strs[i] = String.valueOf(nums[i]);

            Arrays.sort(strs, (str1,str2)->(str1+str2).compareTo(str2+str1));
            StringBuilder res = new StringBuilder();
            for (String str : strs)
                res.append(str);
            return res.toString();
        }
    }
}

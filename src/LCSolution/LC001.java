package LCSolution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LC001 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();

            int num;
            for (int i=0;i<nums.length;i++){
                num = target - nums[i];
                if (map.containsKey(num)){
                    return new int[]{i,map.get(num)};
                }
                map.put(nums[i],i);
            }
            return new int[]{-1,-1};
        }
    }

}

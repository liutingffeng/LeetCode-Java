package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC220 {

    class Solution {

        //或者hashset存储K个值
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

            Map<Integer,Integer> map = new HashMap<>();
            for (int i=0;i<nums.length;i++){
                if (map.containsKey(nums[i]) && (i-map.get(nums[i]))<=k)
                    return true;
                map.put(nums[i],i);
            }
            return false;
        }
    }
}

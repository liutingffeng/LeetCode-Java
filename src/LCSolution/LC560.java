package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC560 {

    class Solution {

        // 前缀和
//        public int subarraySum(int[] nums, int k) {
//
//             Map<Integer,Integer> map = new HashMap<>();
//             map.put(0, 1);
//
//             int count = 0;
//             int sum = 0;
//             for (int num:nums){
//                 sum +=num;
//                 if (map.containsKey(sum-k))
//                     count +=map.get(sum-k);
//
//                 map.put(sum, map.getOrDefault(sum, 0)+1);
//             }
//             return count;
//        }

        public int subarraySum(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(0,1);

            int res = 0;
            int sum = 0;
            for (int num:nums){
                sum +=num;
                if (map.containsKey(sum-k)){
                    res += map.get(sum-k);
                }

                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
            return res;
        }
    }
}

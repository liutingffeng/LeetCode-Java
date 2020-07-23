package LCSolution;

import java.util.*;

public class LC015 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int num:nums)
                map.put(num,map.getOrDefault(num, 0)+1);

            List<List<Integer>> res = new ArrayList<>();
            if (map.containsKey(0)&&map.get(0)>=3)
                res.add(Arrays.asList(0,0,0));

            //去重
            Arrays.sort(nums);
            int left = 1;
            int right = 1;
            while (right<nums.length){
                if (nums[right]!=nums[right-1])
                    nums[left++] = nums[right];
                right++;
            }
            for (int i=0;i<left;i++){
                for (int j=i+1;j<left;j++){
                    if (nums[i]*2+nums[j] == 0 && map.get(nums[i])>1)
                        res.add(Arrays.asList(nums[i],nums[i],nums[j]));
                    if (nums[j]*2+nums[i] == 0 && map.get(nums[j])>1)
                        res.add(Arrays.asList(nums[i],nums[j],nums[j]));

                    int c = 0-nums[i]-nums[j];
                    if (c > nums[j] && map.containsKey(c))
                        res.add(Arrays.asList(nums[i],nums[j],c));
                }
            }

            return res;

        }
    }
}

package LCSolution;

import java.util.*;
import java.util.stream.Collectors;

public class LC473 {

    class Solution {

        // 从大到小的顺序排序，减少回溯
        public boolean makesquare(int[] nums) {
            if (nums.length<4)
                return false;

            int sum = 0 ;
            for (int num:nums)
                sum+=num;

            if ((sum % 4) !=0)
                return false;

            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(list,Collections.reverseOrder());
            for (int i = 0; i < nums.length; i++) {
                nums[i] = list.get(i);
            }

            int[] bucket = new int[4];

            return dfs(nums,bucket,0,sum/4);
        }

        private boolean dfs (int[] nums, int[] bucket,int i,int target){
            if (i>=nums.length){
                return bucket[0] == target && bucket[1] == target
                        && bucket[2] == target && bucket[3] == target;
            }

            for (int j = 0; j < 4; j++) {
                if (bucket[j]+nums[i] > target)
                    continue;

                bucket[j] += nums[i];
                if (dfs(nums, bucket, i+1, target))
                    return true;
                bucket[j] -= nums[i];
            }
            return false;
        }
    }
}

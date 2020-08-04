package LCSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC016 {

    class Solution {

        public int threeSumClosest(int[] nums, int target) {
            boolean isFirst = true;
            int res = 0;

            // 数组排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length ; i++) {

                if (i>0 && nums[i] == nums[i-1])
                    continue;
                // 双指针
                int l = i+1, r = nums.length-1;
                while (l<r){
                    int sum = nums[i]+nums[l]+nums[r];
                    // 优化1 ： 如果和为 target 直接返回答案
                    if (sum == target) {
                        return target;
                    }

                    if (isFirst || Math.abs(sum-target)<Math.abs(res-target)){
                        res = sum;
                        isFirst = false;
                    }
                    if (sum > target) {
                        // 优化2 ： 去重
                        while (l<r && nums[r-1] == nums[r])
                            r --;
                        r--;
                    }
                    else {
                        while (l<r && nums[l+1] == nums[l])
                            l ++;
                        l++;
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        new LC016().new Solution().threeSumClosest(new int[]{1,1,-1,-1,3},-1);
    }
}

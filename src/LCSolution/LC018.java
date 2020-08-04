package LCSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC018 {

    class Solution {

        // 四数之和
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 4)
                return res;

            Arrays.sort(nums);

            for (int i = 0; i < nums.length-3; i++) {

                // 去重
                if (i>0 && nums[i] == nums[i-1])
                    continue;

                // 优化 ：
                //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                int minV = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
                if (minV > target)
                    break;

                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，这一轮不用继续了*/
                int maxV = nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
                if (maxV < target){
                    continue;
                }


                // 三数之和
                for (int j = i+1; j < nums.length-2; j++) {

                    if (j>i+1 && nums[j] == nums[j-1])
                        continue;

                    int h = nums.length-1;
                    /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                    int min=nums[i]+nums[j]+nums[j+1]+nums[j+2];
                    if(min>target){
                        continue;
                    }
                    /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                    int max=nums[i]+nums[j]+nums[h]+nums[h-1];
                    if(max<target){
                        continue;
                    }


                    // 双指针
                    int l = j+1, r = nums.length-1;
                    while (l<r){
                        int sum = nums[i]+nums[j]+nums[l]+nums[r];
                        if (sum == target){
                            // 可变参数
                            res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                            // 去重
                            while (l<r && nums[l+1] == nums[l])
                                l++;
                            while (l<r && nums[r-1] == nums[r])
                                r--;
                            l++;
                            r--;
                        } else if (sum > target)
                            r -- ;
                        else
                            l ++;
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        new LC018().new Solution().fourSum(new int[]{0,0,0,0},0);
    }
}

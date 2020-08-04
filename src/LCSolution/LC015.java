package LCSolution;

import java.util.*;

public class LC015 {

    class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//            Map<Integer,Integer> map = new HashMap<>();
//            for (int num:nums)
//                map.put(num,map.getOrDefault(num, 0)+1);
//
//            List<List<Integer>> res = new ArrayList<>();
//            if (map.containsKey(0)&&map.get(0)>=3)
//                res.add(Arrays.asList(0,0,0));
//
//            //去重
//            Arrays.sort(nums);
//            int left = 1;
//            int right = 1;
//            while (right<nums.length){
//                if (nums[right]!=nums[right-1])
//                    nums[left++] = nums[right];
//                right++;
//            }
//            for (int i=0;i<left;i++){
//                for (int j=i+1;j<left;j++){
//                    if (nums[i]*2+nums[j] == 0 && map.get(nums[i])>1)
//                        res.add(Arrays.asList(nums[i],nums[i],nums[j]));
//                    if (nums[j]*2+nums[i] == 0 && map.get(nums[j])>1)
//                        res.add(Arrays.asList(nums[i],nums[j],nums[j]));
//
//                    int c = 0-nums[i]-nums[j];
//                    if (c > nums[j] && map.containsKey(c))
//                        res.add(Arrays.asList(nums[i],nums[j],c));
//                }
//            }
//
//            return res;
//
//        }


        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3)
                return res;

            // 数组排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length ; i++) {
                // 因为数组已经是排好序的，后面不可能有小于0的数
                if (nums[i]>0)
                    break;

                if (i>0 && nums[i] == nums[i-1])
                    continue;
                // 双指针
                int l = i+1, r = nums.length-1;
                while (l<r){
                    if (nums[i]+nums[l]+nums[r] == 0){
                        // 可变参数
                        res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        // 去重
                        while (l<r && nums[l+1] == nums[l])
                            l++;
                        while (l<r && nums[r-1] == nums[r])
                            r--;
                        l++;
                        r--;
                    } else if (nums[i]+nums[l]+nums[r] > 0)
                        r -- ;
                    else
                        l ++;
                }
            }

            return res;
        }
    }
}

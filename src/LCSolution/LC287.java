package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC287 {

    class Solution {
        //快慢指针寻找环
//        public int findDuplicate(int[] nums) {
//            int n = nums.length;
//            int slow = nums[0];
//            int fast = nums[0];
//            while (fast<n){
//                fast = nums[nums[fast]];
//                slow = nums[slow];
//                if (fast == slow)
//                    break;
//            }
//
//            int cycle = nums[0];
//            while (cycle!=slow){
//                cycle = nums[cycle];
//                slow = nums[slow];
//            }
//            return cycle;
//        }


        //二分查找法
        // nums 里的数字位于 [0...n-1]
        public int findDuplicate(int[] nums) {
            int n = nums.length;
            int left = 0;
            int right = nums.length-1;
            while (left<right){
                int mid = (left+right)>>1;

                //统计小于等于mid的个数
                int count = 0;
                for (int num:nums)
                    if (num<=mid)
                        count++;

                //二分
                if (count>mid){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            return left;
        }
    }
}

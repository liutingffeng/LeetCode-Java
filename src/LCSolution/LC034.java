package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC034 {

    class Solution {
//        public int[] searchRange(int[] nums, int target) {
//            if (nums == null || nums.length==0){
//                return new int[]{-1, -1};
//            }
//            int l = 0;
//            int r = nums.length-1;
//            int rl = -1,rr = -1;
//            while (l<=r){
//                int mid = (l+r)>>1;
//
//                if (nums[mid] == target){
//                    rl = mid;
//                    rr = mid;
//                    while (rr < r && nums[rr+1] == target){
//                        rr++;
//                    }
//                    while (rl > l && nums[rl-1] == target){
//                        rl--;
//                    }
//                    break;
//                }
//
//                if (nums[mid] < target){
//                    l = mid+1;
//                }
//                else {
//                    r = mid-1;
//                }
//            }
//            return new int[]{rl,rr};
//        }

        public int[] searchRange(int[] nums, int target) {
            int l =0,r = nums.length-1;
            int l1 = -1,l2 = -1;
            while (l<=r){
                int mid = l+(r-l)/2;
                if (nums[mid]<target){
                    l = mid+1;
                }
                else {
                    r = mid-1;
                }
            }

            if (l<nums.length && nums[l] == target){
                l1 = l;
                while (l<nums.length && nums[l]==target){
                    l2 = l;
                    l++;
                }
            }

            return new int[]{l1,l2};
        }
    }
}

package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC033 {

    class Solution {
//        public int search(int[] nums, int target) {
//            if (nums == null || nums.length==0){
//                return -1;
//            }
//            int l = 0;
//            int r = nums.length-1;
//            while (l<=r){
//                int mid = l+(r-l)/2;
//                if (nums[mid] == target){
//                    return mid;
//                }
//
//                if (nums[l] <= nums[mid]){
//                    if (target>=nums[l] && target<nums[mid])
//                        r = mid-1;
//                    else
//                        l = mid+1;
//                }
//                else {
//                    if (target<=nums[r] && target>nums[mid])
//                        l = mid+1;
//                    else
//                        r = mid-1;
//                }
//            }
//            return -1;
//
//        }

        public int search(int[] nums, int target) {
            int l=0,r=nums.length-1;

            while (l<=r){
                int mid = l+(r-l)/2;
                if (nums[mid] == target){
                    return mid;
                }

                // 递增区间
                if (nums[l] <= nums[mid]){
                    if (nums[l]<=target && target<=nums[mid])
                        r = mid-1;
                    else
                        l = mid +1;
                }  // [mid+1,r] 为递增区间
                else {
                    if (target<=nums[r] && target>=nums[mid]){
                        l = mid+1;
                    }
                    else
                        r = mid-1;
                }
            }
            return -1;
        }


    }
}

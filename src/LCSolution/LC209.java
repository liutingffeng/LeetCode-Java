package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC209 {

    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int res = nums.length+1;
            int sum = 0;
            int l = 0;
            int r = 0;
            while (r<nums.length){
                sum +=nums[r];
                r++;

                while (sum >= s){
                    res = Math.min(res, r-l);
                    sum -= nums[l];
                    l++;
                }
            }
            return res == nums.length+1 ? 0:res;
        }


//        // 前缀和+ 二分查找
//        public int minSubArrayLen(int s, int[] nums) {
//            if (nums == null || nums.length == 0)
//                return 0;
//            int n = nums.length;
//            int[] sums = new int[n+1];
//            // sums[i] 代表 前i个元素和
//            for (int i = 0; i < n; i++) {
//                sums[i+1] = sums[i] + nums[i];
//            }
//            int res = n+1;
//
//            // sums[j]-sums[i]>=s
//            // sums[i]+s<=sums[j]
//            for (int i = 0; i <n ; i++) {
//                int target = sums[i] + s;
//                // 在[i+1,n] 中二分查找
//                int l = i+1, r = n;
//                while (l<=r){
//                    int mid = l + (r-l)/2;
//                    if (sums[mid]>=target){
//                        res = Math.min(res, mid-i);
//                        r = mid-1;
//                    }
//                    else {
//                        l = mid+1;
//                    }
//                }
//            }
//            return res == nums.length+1 ? 0 : res;
//        }
    }
}

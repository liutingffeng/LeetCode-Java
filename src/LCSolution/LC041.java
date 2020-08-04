package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC041 {

    class Solution {
//        public int firstMissingPositive(int[] nums) {
//            int n =nums.length;
//            for (int i = 0; i < n; i++) {
//                if (nums[i]<0)
//                    nums[i] = 0;
//            }
//
//            for (int i = 0; i < n; i++) {
//                int index = Math.abs(nums[i]);
//                if (index>0 && index<=n){
//                    nums[index-1] = nums[index-1] == 0 ? -(n+1):-Math.abs(nums[index-1]);
//                }
//            }
//            int res = n+1;
//            for (int i = 0; i < n; i++) {
//                if (nums[i]>=0){
//                    res = i+1;
//                    break;
//                }
//            }
//            return res;
//        }

        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i]<=n && (nums[nums[i]-1] != nums[i]))
                    swap(nums,i,nums[i]-1);
            }

            for (int i = 0; i < n; i++) {
                if (nums[i]!=i+1)
                    return i+1;
            }
            return n+1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC448 {

    class Solution {
//        public List<Integer> findDisappearedNumbers(int[] nums) {
//            List<Integer> res = new ArrayList<>();
//            for (int num:nums){
//                nums[Math.abs(num) - 1] = -Math.abs(nums[Math.abs(num) - 1]);
//
//            }
//
//            for (int i=0;i<nums.length;i++)
//                if (nums[i]>0)
//                    res.add(i+1);
//
//            return res;
//        }

        // 和索引异或运算
//        public int missingNumber(int[] nums) {
//            int n = nums.length;
//            int res = 0;
//            // 先和新补的索引异或一下
//            res ^= n;
//            for (int i = 0; i < n; i++) {
//                res ^= i^nums[i];
//            }
//            return res;
//        }


        // 等差数列求和
//        public int missingNumber(int[] nums) {
//            int n = nums.length;
//            int expect = ((1+n)*n)/2;
//
//            int sum = 0;
//            for (int num : nums)
//                sum += num;
//            return expect-sum;
//        }


        // 防止溢出
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int res = 0;
            // 补索引
            res = n - 0;
            for (int i = 0; i < n; i++) {
                res += (i-nums[i]);
            }
            return res;
        }
    }
}

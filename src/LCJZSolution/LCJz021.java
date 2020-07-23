package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz021 {

    class Solution {
        public int[] exchange(int[] nums) {
            if (nums == null || nums.length<=1)
                return nums;

            int left = 0;   // [0,slow) 奇数
            int right = nums.length-1;
            while (left<right){
                if ((nums[left]&1)==1)
                    left++;
                else if ((nums[right]&1)==0)
                    right--;
                else {
                    int temp = nums[left];
                    nums[left++] = nums[right];
                    nums[right--] = temp;
                }
            }
            return nums;
        }
    }
}

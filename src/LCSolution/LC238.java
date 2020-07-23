package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] right = new int[n];
            right[n-1] = 1;
            for (int i=n-2;i>=0;i--){
                right[i] = nums[i+1]*right[i+1];
            }
            int k = 1;
            for (int i=0;i<n;i++){
                right[i] = right[i]*k;
                k = k*nums[i];
            }
            return right;
        }
    }
}

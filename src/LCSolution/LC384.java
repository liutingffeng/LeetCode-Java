package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC384 {

    class Solution {
        int[] origin;
        int[] nums;
        Random rand = new Random();
        public Solution(int[] nums) {
            int n = nums.length;
            origin = new int[n];
            for (int i = 0; i < n; i++) {
                origin[i] = nums[i];
            }
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                int j = rand.nextInt((n-i))+i;
                swap(nums, i, j);
            }
            return nums;
        }

        private void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC398 {

    class Solution {
        int[] nums;
        Random rand = new Random();
        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int index = 0;
            int c = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target){
                    if (rand.nextInt(++c) == 0)
                        index = i;
                }
            }
            return index;
        }
    }
}

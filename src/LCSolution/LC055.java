package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC055 {

    class Solution {
        //非负整数
//        public boolean canJump(int[] nums) {
//            nums[nums.length-1] = 0;
//            for (int i=nums.length-2;i>=0;i--){
//                for (int j=1;j<=nums[i];j++){
//                    if (nums[i+j] == 0){
//                        nums[i] = 0;
//                        break;
//                    }
//                }
//            }
//            return nums[0] == 0;
//        }

        //
        public boolean canJump(int[] nums) {
            int lastPos = nums.length-1;
            for (int i=nums.length-2;i>=0;i--){
                if ((i+nums[i])>=lastPos )
                    lastPos = i;
            }
            return lastPos == 0;
        }
    }
}

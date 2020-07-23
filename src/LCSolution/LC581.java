package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC581 {

    class Solution {
        //单调栈
//        public int findUnsortedSubarray(int[] nums) {
//            Deque<Integer> deque = new ArrayDeque<>();
//            int l = nums.length;
//            for (int i=0;i<nums.length;i++){
//                while (!deque.isEmpty() && nums[i]<nums[deque.peekLast()]){
//                    l = Math.min(l, deque.pollLast());
//                }
//                deque.addLast(i);
//            }
//            deque.clear();
//            int r = 0;
//            for (int i=nums.length-1;i>=0;i--){
//                while (!deque.isEmpty() && nums[i]>nums[deque.peekLast()]){
//                    r = Math.max(r, deque.pollLast());
//                }
//                deque.addLast(i);
//            }
//            return (r-l) > 0 ? r-l+1:0;
//        }

        //从左到右找出最后一个破坏递增的数
        //
        //从右到左找出最后一个破坏递减的数
        public int findUnsortedSubarray(int[] nums) {
            if (nums.length == 1)
                return 0;

            int high = 0;
            int low = nums.length;
            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;
            int len = nums.length;

            for (int i=0;i<nums.length;i++){
                if (nums[i]>=maxValue)
                    maxValue = nums[i];
                else
                    high = i;

                if (nums[len-1-i]<=minValue)
                    minValue = nums[len-1-i];
                else
                    low = len-i-1;
            }

            return high>low ? high-low+1:0;
        }
    }
}

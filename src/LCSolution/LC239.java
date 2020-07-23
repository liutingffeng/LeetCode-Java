package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239 {

    class Solution {
        //双端队列，最大值一直在头部
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;

            Deque<Integer> deque = new ArrayDeque<>();
            int[] res = new int[n-k+1];
            //初始化队列
            for (int i=0;i<k;i++){
                while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            res[0] = nums[deque.peekFirst()];
            int l = 0; //[l,k]
            while (k<n){
                int maxIndex = deque.peekFirst();
                if (l == maxIndex)
                    deque.pollFirst();
                while (!deque.isEmpty() && nums[k]>=nums[deque.peekLast()])
                    deque.pollLast();
                deque.addLast(k);
                l++;
                k++;
                res[l] = nums[deque.peekFirst()];
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new LC239().new Solution();
        int[] nums =  {1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(nums, 3);
    }
}

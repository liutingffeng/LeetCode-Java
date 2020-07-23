package LCJZSolution;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class LCJz059I {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 )
                return new int[0];
            Deque<Integer> queue = new ArrayDeque<>();
            int[] res = new int[nums.length-k+1];
            //初始化
            int i=0;
            int r = nums.length-k;
            while (i<=r){
                if (i == 0){
                    //初始化
                    for (int j=0;j<k;j++){
                        while (!queue.isEmpty() && nums[j]>queue.peekLast()){
                            queue.pollLast();
                        }
                        queue.addLast(nums[j]);
                    }
                }
                res[i] = queue.peekFirst();
                if (i == r)
                    break;
                if (nums[i] == queue.peekFirst()){
                    queue.pollFirst();
                }
                int j = i+k;
                while (!queue.isEmpty() && nums[j]>queue.peekLast()){
                    queue.pollLast();
                }
                queue.addLast(nums[j]);
                i++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        Deque<Integer> queue = new ArrayDeque<>();
//        queue.addLast(1);
//        queue.addLast(2);
//
//        int n = queue.size();
//        for (int i=0;i<n;i++)
//            System.out.println(queue.pollLast());
        int[] nums = {1,3,1,2,0,5};
        new LCJz059I().new Solution().maxSlidingWindow(nums, 3);
    }
}

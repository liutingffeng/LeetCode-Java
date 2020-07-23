package LCSolution;

import java.util.*;

public class LC215 {

    class Solution {

        //最大堆
//        public int findKthLargest(int[] nums, int k) {
//            PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->o2-o1);
//            for (int num:nums)
//                q.add(num);
//            while (--k>0){
//                q.poll();
//            }
//            return q.peek();
//        }

        //快排，剪枝
        public int findKthLargest(int[] nums, int k) {
            partition(nums, 0, nums.length-1, k);
            return nums[k-1];
        }

        private void partition(int[] nums,int l,int r,int k){
            if (l>=r)
                return;

            //随机化种子
            int index = l + new Random().nextInt((r-l) + 1);
            swap(nums, l, index);
            int pivot = nums[l];
            int lr = l+1;//[1+1...lr)
            int rl = r;//(rl...r]
            int i = lr;// [lr...rl-1]
            while (i<=rl){
                if (nums[i]<pivot){
                    swap(nums, i, rl--);
                }
                else if (nums[i]>pivot){
                    swap(nums, i++, lr++);
                }
                else {
                    i++;
                }
            }
            swap(nums,l,lr-1);
            if (lr == k)
                return;
            else if (lr<k)
                partition(nums, rl+1, r, k);
            else
                partition(nums, l, lr-2, k);
        }

        private void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            return;
        }
    }
}

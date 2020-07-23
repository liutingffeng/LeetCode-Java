package LCSolution;

import java.util.*;

public class LC315 {

    class Solution {
        // 二分查找加插入
//        public List<Integer> countSmaller(int[] nums) {
//
//            int n = nums.length;
//            Integer[] res = new Integer[n];
//            List<Integer> sorted = new ArrayList<>();
//
//            for (int i = n-1; i >=0 ; i--) {
//                if (i == n-1){
//                    sorted.add(nums[i]);
//                    res[i] = 0;
//                }
//                else {
//                    int ins = findInsert(sorted,nums[i]);
//                    res[i] = ins;
//                    sorted.add(ins, nums[i]);
//                }
//            }
//
//            return Arrays.asList(res);
//        }
//
//        //二分查找
//        private int findInsert(List<Integer> sorted , int target){
//            int r = sorted.size()-1;
//            int l=0;
//            while (l<=r){
//                int mid = l+(r-l)/2;
//                if (sorted.get(mid)<target){
//                    l = mid+1;
//                }
//                else {
//                    r = mid-1;
//                }
//            }
//            return l;
//        }


        // 归并排序
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length == 0)
                return result;
            int len = nums.length;

            int[] temp = new int[len];
            int[] res = new int[len];

            // 索引数组，作用：归并回去的时候，方便知道是哪个下标的元素
            //真正操作的是索引数组的值
            int[] indexes = new int[len];
            for (int i = 0; i < len; i++) {
                indexes[i] = i;
            }

            mergeAndCountSmaller(nums, 0, len - 1, indexes, temp, res);

            for (int i:
                 res) {
                result.add(i);
            }
            return result;
        }

        private void mergeAndCountSmaller(int[] nums, int l, int r, int[] indexes, int[] temp, int[] res) {
            if (l>=r)
                return;

            int mid = l+(r-l)/2;

            mergeAndCountSmaller(nums, l, mid, indexes, temp, res);
            mergeAndCountSmaller(nums, mid+1, r, indexes, temp, res);
            //优化，不用归并
            if (nums[indexes[mid]]<=nums[indexes[mid+1]])
                return;

            merge(nums,l,mid,r,indexes,temp,res);
        }

        private void merge(int[] nums, int l, int mid, int r, int[] indexes, int[] temp, int[] res) {
            for (int i = l; i <=r ; i++) {
                temp[i] = indexes[i];
            }

            int i = l,j = mid+1;
            for (int k = l; k <= r; k++) {
                if (i>mid){
                    indexes[k] = temp[j++];
                }
                else if (j>r){
                    indexes[k] = temp[i++];
                    //业务处理
                    res[indexes[k]] += (r - mid);
                }
                else if (nums[temp[i]]<=nums[temp[j]]){
                    indexes[k] = temp[i++];
                    res[indexes[k]] += (j-mid-1);
                }
                else {
                    indexes[k] = temp[j++];
                }
            }
        }


    }

    public static void main(String[] args) {
        new LC315().new Solution().countSmaller(new int[]{5,2,6,1});
        int[] arr = new int[]{5,2,6,1};
        for (int i:arr){
            System.out.println(i);
        }
    }
}

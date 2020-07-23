package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz051 {

    class Solution {
        int count = 0;
        //归并排序+分治思想
        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            mergeSort(nums, 0, nums.length-1, new int[nums.length]);
            return count;
        }

        public void mergeSort(int[] nums,int l,int r,int[] temp){
            if (l>=r)
                return;

            int mid = l + (r-l)/2;

            mergeSort(nums, l, mid, temp);
            mergeSort(nums, mid+1, r, temp);

            if (nums[mid]<=nums[mid+1])
                return;

            merge(nums, l, mid, r, temp);

        }

        public void merge(int[] nums,int l,int mid,int r,int[] temp){
            for (int i=l;i<=r;i++){
                temp[i] = nums[i];
            }

            int i = l, j = mid+1;
            for (int k=l;k<=r;k++){

                if (i == mid+1){
                    nums[k] = temp[j];
                    j++;
                }
                else if (j == r+1){
                    nums[k] = temp[i];
                    i++;
                }
                else if (temp[i] > temp[j]){
                    nums[k] = temp[j];
                    count += mid-i+1;
                    j++;
                }
                else {
                    nums[k] = temp[i];
                    i++;
                }
            }


        }

    }
}

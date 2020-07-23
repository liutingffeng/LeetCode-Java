package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC031 {

    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1){
                return ;
            }
            //数组从后玩前找第一个升序对[i,j]，如果没找到，就代表整个数组降序排列，是最大的数字了，直接逆置
            int j = nums.length-1;
            int i = -1;
            boolean flag = false;
            while (j>=1){
                if (nums[j-1]<nums[j]){
                    flag = true;
                    i = j-1;
                    break;
                }
                j--;
            }
            if (flag == false){
                // 654321 --> 123456
                reverse(nums, 0, nums.length-1);
                return;
            }
            else {
                //从[j,end)中找到第一个大于nums[i]的数，并交换
                for (int k=nums.length-1;k>=j;k--){
                    if (nums[k]>nums[i]){
                        swap(nums, i, k);
                        break;
                    }
                }
                //此时[j,end)仍是降序,逆置
                reverse(nums, j, nums.length-1);
            }
            return;
        }

        private void reverse(int[] nums,int i,int j){
            if (nums == null || nums.length <=1){
                return;
            }
            while (i<j){
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

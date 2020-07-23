package LCSolution;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC075 {

    class Solution {

        //计数排序
//        public void sortColors(int[] nums) {
//            int[] record = new int[3];
//            for (int num:nums){
//                record[num]++;
//            }
//            //第二趟扫描
//            int i=record[0];
//            int j=record[1];
//            int k=record[2];
//            int index = 0;
//            while (i-->0){
//                nums[index++] = 0;
//            }
//            while (j-->0)
//                nums[index++]=1;
//            while (k-->0)
//                nums[index++]=2;
//        }

        //快速排序
//        public void sortColors(int[] nums) {
//            //[0,left) 0
//            //[right,nums.length-1] 2
//            int left = 0;
//            int right = nums.length-1;
//            int index = 0;
//            while (index<right){
//                if (nums[index]==0){
//                    nums[index++] = 1;
//                    nums[left++] = 0;
//                }
//                else if (nums[index]==2){
//                    nums[index] = nums[right];
//                    nums[right--] = 2;
//                }
//                else {
//                    index++;
//                }
//            }
//        }

        public void sortColors(int[] nums) {
            int l = 0;  //[0,l)  0
            int r = nums.length;  //[r,n-1]  2;
            int index = 0;
            while (index<r){
                if (nums[index] == 0){
                    nums[index] =  nums[l];
                    nums[l++] = 0;
                }
                else if (nums[index] == 2){
                    nums[index] = nums[--r];
                    nums[r] = 2;
                }
                else
                    index++;
            }

        }

    }
}

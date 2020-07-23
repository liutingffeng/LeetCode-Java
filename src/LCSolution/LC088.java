package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC088 {

    class Solution {
//        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            int[] nums1_copy = new int[m];
//            System.arraycopy(nums1,0,nums1_copy, 0, m);
//            int i=0;
//            int j=0;
//            int index = 0;
//            while (i<m || j<n){
//                if (i == m){
//                    while (j<n)
//                        nums1[index++] = nums2[j++];
//                    break;
//                }
//                if (j == n){
//                    while (i<m)
//                        nums1[index++] = nums1_copy[i++];
//                    break;
//                }
//
//                if (nums1_copy[i]<nums2[j]){
//                    nums1[index++] = nums1_copy[i++];
//                }
//                else
//                    nums1[index++] = nums2[j++];
//            }
//            return;
//        }

        //双指针，从后往前  不使用额外空间
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m-1;
            int p2 = n-1;
            int p = m+n-1;

            while (p1>=0 && p2>=0){

                nums1[p--] = (nums1[p1]>nums2[p2]) ? nums1[p1--]:nums2[p2--];
            }

            System.arraycopy(nums2, 0, nums1, 0, p2+1);
        }
    }
}

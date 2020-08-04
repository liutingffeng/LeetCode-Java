package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC004 {

    class Solution {
//        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//            // 保证nums1是短的哪一个
//            if (nums1.length > nums2.length){
//                int[] temp = nums1;
//                nums1 = nums2;
//                nums2 = temp;
//            }
//
//            int m = nums1.length;
//            int n = nums2.length;
//            // 分割线左边的元素个数
//            int totalLeft = (m+n+1)/2;
//
//             // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
//            // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
//            // i 为nums1分割线右边的第一个元素 ， j 为nums2
//            int left = 0, right = m;
//            while (left < right) {
//                int i = left + (right - left + 1) / 2;
//                int j = totalLeft - i;
//                if (nums1[i - 1] > nums2[j]) {
//                    // 下一轮搜索的区间 [left, i - 1]
//                    right = i - 1;
//                } else {
//                    // 下一轮搜索的区间 [i, right]
//                    left = i;
//                }
//            }
//
//            int i = left;
//            int j = totalLeft - i;
//            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
//            int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
//            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
//            int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
//
//            if (((m + n) % 2) == 1) {
//                return Math.max(nums1LeftMax, nums2LeftMax);
//            } else {
//                return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
//            }
//        }

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;

            if ((m+n)%2 == 1){
                return findKth(nums1, 0, nums2, 0, (m+n)/2+1);
            }
            return (findKth(nums1, 0, nums2, 0, (m+n)/2)+
                    findKth(nums1, 0, nums2, 0, (m+n)/2+1))/2.0;
        }


        // i , j 代表数组开始的位置
        private int findKth(int[] nums1,int i,int[] nums2,int j,int k){
            if (i>= nums1.length){
                return nums2[j+k-1];
            }
            if (j>=nums2.length){
                return nums1[i+k-1];
            }

            // 到底
            if (k == 1){
                return Math.min(nums1[i],nums2[j]);
            }

            int val1 = (i+k/2-1)<nums1.length ? nums1[i+k/2-1]:Integer.MAX_VALUE;
            int val2 = (j+k/2-1)<nums2.length ? nums2[j+k/2-1]:Integer.MAX_VALUE;

            if (val1<val2){
                return findKth(nums1, i+k/2, nums2, j, k - k/2);
            }
            else {
                return findKth(nums1, i, nums2, j+k/2, k-k/2);
            }
        }
    }
}

package LC2026.sixMonth;

import LC2025.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC031 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 从后往前找第一个降序的数字
        int descIndex = -1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] < nums[i+1]) {
                descIndex = i;
                break;
            }
        }
        // 如果没找到
        if (descIndex == -1) {
            swap(nums, 0, nums.length - 1);
            return;
        }
        // 从后往前找比当前数字大的
        int i = nums.length - 1;
        while (i > descIndex) {
            if (nums[i] > nums[descIndex]) {
                // 交换
                int t = nums[i];
                nums[i] = nums[descIndex];
                nums[descIndex] = t;
                break;
            }
            i--;
        }
        // 让剩余的升序
        swap(nums, descIndex + 1, nums.length - 1);
    }

    private void swap(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l++] = nums[r];
            nums[r--] = t;
        }
    }
}

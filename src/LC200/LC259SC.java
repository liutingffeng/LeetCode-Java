package LC200;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组和一个目标值 target ，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 *      [-2,0,3]
 * 示例 2：
 *
 * 输入: nums = [], target = 0
 * 输出: 0
 * 示例 3：
 *
 * 输入: nums = [0], target = 0
 * 输出: 0
 *
 */
public class LC259SC {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length <= 2)
            return 0;

        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int newTarget = target - nums[i] - nums[j];
                int index = find(nums, j+1, nums.length - 1, newTarget);
                if (index > j && index < nums.length) {
                    if (nums[index] < newTarget) {
                        res += (index - j);
                    }
                }
            }
        }
        return res;
    }

    private int find(int[] nums, int l, int r, int val) {
        if (l > r)
            return 0;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (nums[mid] >= val) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
//        new LC259().find(new int[]{-2, 0, 1, 3}, 0, 3, 2);
        new LC259SC().threeSumSmaller(new int[]{-2, 0, 1, 3}, 2);
    }
}

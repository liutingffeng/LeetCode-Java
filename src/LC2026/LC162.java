package LC2026;

public class LC162 {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间元素小于右邻居，说明峰值在右边
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // 中间元素大于等于右邻居，峰值在左边或就是mid
                right = mid;
            }
        }
        return left;
    }

}

package Traveloka;

/**
 * @Author liutingfeng
 * @Date 2026/7/31 17:25
 */
public class LC004 {

    // 搜索旋转数组

    /**
     * nums = [4, 5, 6, 7, 0, 1, 2]
     * target = 0
     *
     * 输出：
     * 4
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // 左半部分有序
            // 只有一个元素的场景，才会等于
            if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // 右半部分有序
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int result = search(
                new int[]{4, 5, 6, 7, 0, 1, 2},
                0
        );

        System.out.println(result); // 4
    }

}

package LC2022;

public class LC038 {

    /**
     * 1  1
     * 2  11
     * 3  21
     * 4  1211
     * 5  111221
     * 6  312211
     * 7  13112221
     * 8  1113213211
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 左边有序
            if (nums[l] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                continue;
            }
            if (nums[mid] <= nums[r]) {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        search(nums, 0);
    }
}

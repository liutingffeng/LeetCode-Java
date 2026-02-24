package LC2026;

public class LC035 {

    public int searchInsert(int[] nums, int target) {
        // 二分
        int i= 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (target > nums[i])
            return i + 1;
        return i;
    }


}

package LC2023;

public class LC026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 2)
            return nums.length;

        int l = 0, r = 1;
        while (r < nums.length) {
            int left = nums[l];
            int right = nums[r];
            if (left == right) {
                r++;
            } else {
                if (r - l == 1) {
                    l++;
                    r++;
                } else {
                    nums[++l] = right;
                    r++;
                }
            }
        }
        return ++l;
    }
}

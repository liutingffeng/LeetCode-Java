package LC2026;

public class LC026 {

    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length <= 1)
            return nums.length;

        int l = 0, r = l + 1;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                r++;
            } else {
                if ((l + 1) != r) {
                    nums[l + 1] = nums[r];
                }
                l++;
                r++;
            }
        }
        return l + 1;
    }


}

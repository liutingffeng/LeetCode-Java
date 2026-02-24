package LC2026;

public class LC027 {

    public int removeElement(int[] nums, int val) {
        if (nums == null)
            return 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] == val) {
                r++;
            } else {
                if (l != r) {
                    nums[l] = nums[r];
                }
                l++;
                r++;
            }
        }
        return l;
    }


}

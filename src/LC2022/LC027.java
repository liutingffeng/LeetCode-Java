package LC2022;

public class LC027 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = 0;
        while (r < nums.length) {
            if (l == r) {
                if (nums[r] != val) {
                    l ++;
                }
                r ++;
            } else {
                if (nums[r] != val) {
                    // swap
                    nums[l++] = nums[r];
                }
                r++;
            }
        }
        return l;
    }
}

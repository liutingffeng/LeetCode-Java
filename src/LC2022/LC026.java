package LC2022;

public class LC026 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int l = 0, r = 1;
        int lval = 0;
        int rval = 0;
        while (r < nums.length) {
            lval = nums[l];
            rval = nums[r];
            if (lval == rval) {
                r ++;
                continue;
            }
            if (rval > lval) {
                nums[++l] = rval;
                r ++;
            }
        }
        return l + 1;
    }
}

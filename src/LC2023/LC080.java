package LC2023;

public class LC080 {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 2)
            return nums.length;

        int l = 0, r = 1;
        int dup = 1;
        while (r < nums.length) {
            int left = nums[l];
            int right = nums[r];
            if (left == right) {
                r++;
                if (dup > 0) {
                    nums[++l] = right;
                    dup --;
                }
            } else {
                if (r - l == 1) {
                    l++;
                    r++;
                    dup = 1;
                } else {
                    nums[++l] = right;
                    r++;
                    dup = 1;
                }
            }
        }
        return ++l;
    }
}

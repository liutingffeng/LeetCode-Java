package LC2026;

public class LC080 {

    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length <= 1)
            return nums.length;

        int l = 0, r = l + 1, k = 1;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                if (k == 1) {
                    if ((l + 1) != r) {
                        nums[l + 1] = nums[r];
                    }
                    l++;
                    k--;
                }
                r++;
            } else {
                if ((l + 1) != r) {
                    nums[l + 1] = nums[r];
                }
                l++;
                r++;
                k = 1;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        new LC080().removeDuplicates(nums);

    }

}

package LC2026;

public class LC209 {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int res = nums.length + 1;
        int cur = 0;
        while ((i <= nums.length - 1) && (j <= nums.length - 1)) {
            cur += nums[j];
            if (cur >= target) {
                res = Math.min(res, (j - i + 1));
                cur -= nums[i];
                cur -= nums[j];
                i++;
            } else {
                j++;
            }
        }
        if (res == (nums.length + 1))
            return 0;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        new LC209().minSubArrayLen(7, nums);
    }
}

package LC2023;

/**
 * @Author liutingfeng
 * @Date 2023/10/17 10:49
 */
public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        // 1 2 3 4
        // 24 12 8 6
        // 1 1 2 6
        //
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = 1;
            } else {
                res[i] = res[i-1] * nums[i-1];
            }
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        new LC238().productExceptSelf(nums);
    }
}

package LC2026;

public class LC031 {

    public void nextPermutation(int[] nums) {
        // 先找到第一个降序的数字
        int a = -1;
        for (int i = nums.length - 1; i > 0 ; i--) {
            if (nums[i-1] < nums[i]) {
                a = i - 1;
                break;
            }
        }
        if (a < 0) {
            // 没找到
            reverse(nums, 0 , nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > a ; i--) {
            if (nums[i] > nums[a]) {
                int t = nums[i];
                nums[i] = nums[a];
                nums[a] = t;
                break;
            }
        }
        reverse(nums, a + 1, nums.length - 1);

    }

    private void reverse(int[] nums, int l , int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }


}

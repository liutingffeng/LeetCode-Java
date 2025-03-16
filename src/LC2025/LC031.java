package LC2025;

public class LC031 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;

        //
        int r = nums.length - 1;
        int l = r - 1;
        int k = r;

        while (l >= 0 && nums[l] >= nums[r]) {
            l --;
            r --;
        }
        // 当前队列不是最后一个
        if (l >= 0) {
            while (nums[l] >= nums[k])
                k--;

            // 交换
            int t = nums[l];
            nums[l] = nums[k];
            nums[k] = t;
        }

        // 逆序 [r, end)
        int x = r;
        int y = nums.length - 1;
        while (x < y) {
            int t =nums[x];
            nums[x] = nums[y];
            nums[y] = t;
            x ++;
            y --;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        new LC031().nextPermutation(nums);
    }
}
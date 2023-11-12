package LC2023;

public class LC189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (k == 0)
            return;
        int[] temp = new int[k];
        for (int i = length - 1; i >= (length - k) ; i--) {
            temp[i - (length - k)] = nums[i];
        }
        for (int i = (length - k - 1); i >= 0 ; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}

package LC2023;

public class LC55 {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex)
                break;
            if ((i + nums[i]) > maxIndex)
                maxIndex = i + nums[i];
        }
        return (nums.length - 1) <= maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        new LC55().canJump(nums);
    }
}

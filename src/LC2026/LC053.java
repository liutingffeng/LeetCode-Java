package LC2026;

public class LC053 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int curretMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            curretMax = Math.max(cur, curretMax + cur);
            maxSum = Math.max(curretMax, maxSum);
        }
        return maxSum;
    }


}

package LC2026;

public class LC045 {

    public int jump(int[] nums) {
        int step = 0;
        int maxLen =0;
        int curEnd = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            maxLen = Math.max(maxLen, i + nums[i]);
            if (i == curEnd) {
                step++;
                curEnd = maxLen;
            }
        }
        return step;
    }


}

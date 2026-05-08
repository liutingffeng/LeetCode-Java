package LCKotlin

class LC053 {

    fun maxSubArray(nums: IntArray): Int {
        val dp: IntArray = IntArray(nums.size)
        var max = 0
        for (i in nums.indices) {
            if (i == 0) {
                dp[i] = nums[i]
                max = nums[i]
            } else {
                dp[i] = if (dp[i-1] > 0) {
                    dp[i-1] + nums[i]
                } else {
                    nums[i]
                }
                max = max.coerceAtLeast(dp[i])
            }
        }
        return max
    }
}
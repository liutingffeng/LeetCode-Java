package LCKotlin

class LC300 {

    fun lengthOfLIS(nums: IntArray): Int {
        var dp: IntArray = IntArray(nums.size){1}
        var max: Int = 1
        for (i in 1..nums.lastIndex) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = (dp[j] + 1).coerceAtLeast(dp[i])
                    max = max.coerceAtLeast(dp[i])
                }
            }
        }
        return max
    }
}
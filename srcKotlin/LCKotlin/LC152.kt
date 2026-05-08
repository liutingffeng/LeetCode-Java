package LCKotlin

class LC152 {

    fun maxProduct(nums: IntArray): Int {
        var maxRes: Int? = null
        var imax = 1
        var imin = 1
        for (i in nums.indices) {
            if (nums[i] < 0) {
                var temp = imax
                imax = imin
                imin = temp
            }
            imax = nums[i].coerceAtLeast(imax * nums[i])
            imin = nums[i].coerceAtMost(imin * nums[i])

            maxRes = maxRes?.coerceAtLeast(imax) ?: imax
        }
        return maxRes!!
    }

}
package LCKotlin

class LC238 {

    fun productExceptSelf(nums: IntArray): IntArray {
        var res: IntArray = IntArray(nums.size, fun (_: Int): Int {
            return 1
        })
        //从左往右
        var t = 1
        for (i in 1 until nums.size) {
            t *= nums[i-1]
            res[i] = t
        }
        // 从右往左
        var rSum = 1
        for (i in nums.size - 2 downTo 0) {
            rSum *= nums[i+1]
            res[i] *= rSum
        }
        return res
    }
}
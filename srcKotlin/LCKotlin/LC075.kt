package LCKotlin

class LC075 {

    fun sortColors(nums: IntArray): Unit {
        var zeroIndex = 0
        var twoIndex = nums.lastIndex
        var i = 0
        while (i <= twoIndex) {
            if (nums[i] == 0) {
                swap(nums, zeroIndex, i)
                if (zeroIndex == i) {
                    i++
                }
                zeroIndex++
            } else if (nums[i] == 2) {
                swap(nums, i, twoIndex)
                twoIndex--
            } else {
                i++
            }
        }
    }

    fun swap(nums: IntArray, l: Int, r: Int) {
        val t = nums[l]
        nums[l] = nums[r]
        nums[r] = t
    }
}
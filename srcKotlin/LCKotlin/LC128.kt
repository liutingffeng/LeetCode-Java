package LCKotlin

class LC128 {

    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toHashSet()
        var maxLength = 0
        for (num in set) {
            if (num - 1 !in set) {
                var length = 1
                var curNum = num + 1
                while (curNum in set) {
                    length++
                    curNum++
                }
                maxLength = maxLength.coerceAtLeast(length)
            }
        }
        return maxLength
    }
}
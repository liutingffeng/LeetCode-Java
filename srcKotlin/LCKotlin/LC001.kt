package LCKotlin

/**
 * 1. Two Sum
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 */
class LC001 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for ((i, num) in nums.withIndex()) {
            val complement = target - num
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[num] = i
        }
        return intArrayOf()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = LC001()
            val nums = intArrayOf(2, 7, 11, 15)
            val target = 9
            val result = solution.twoSum(nums, target)
            println("结果: [${result.joinToString(", ")}]")  // 输出: [0, 1]
        }
    }
}

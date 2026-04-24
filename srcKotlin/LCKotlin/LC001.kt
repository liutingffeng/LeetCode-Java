package LCKotlin

class LC001 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map: MutableMap<Int, Int> = HashMap();
        for (i in nums.indices) {
            map.put(nums[i], i)
        }
        var res: IntArray = IntArray(2)
        for (i in nums.indices) {
            val key = target - nums[i]
            if (map.containsKey(key) && map[key] != i) {
                res[0] = i
                res[1] = map[key]!!
                return res
            }
        }
        return res
    }
}
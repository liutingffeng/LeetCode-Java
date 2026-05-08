package LCKotlin

class LC042 {

    fun trap(height: IntArray): Int {
        var sum: Int = 0
        var left: Int = 0
        var right: Int = height.lastIndex
        var lMaxH = 0
        var rMaxH = 0

        while (left < right) {
            lMaxH = lMaxH.coerceAtLeast(height[left])
            rMaxH = rMaxH.coerceAtLeast(height[right])
            val minH = lMaxH.coerceAtMost(rMaxH)
            val curH = if (height[left] <= height[right]) {
                (minH - height[left++]).coerceAtLeast(0)
            } else {
                (minH - height[right--]).coerceAtLeast(0)
            }
            sum += curH

        }
        return sum
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("124")
            val height: IntArray = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
            LC042().trap(height)
        }
    }
}
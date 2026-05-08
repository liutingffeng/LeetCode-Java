package LCKotlin

class LC011 {

    fun maxArea(height: IntArray): Int {
        var maxRes: Int = 0
        var left: Int = 0
        var right: Int = height.lastIndex

        while (left < right) {
            val leftV = height[left]
            val rightV = height[right]
            maxRes = maxRes.coerceAtLeast(leftV.coerceAtMost(rightV) * (right - left))
            if (leftV <= rightV) {
                left++
            } else {
                right--
            }
        }
        return maxRes
    }
}
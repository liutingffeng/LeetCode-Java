package LCKotlin

import java.util.Stack

class LC739 {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        if (temperatures.size == 1) {
            return IntArray(1)
        }
        var res = IntArray(temperatures.size)
        // 单调栈
        var stack: Stack<Int> = Stack()
        for (i in temperatures.indices) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                // 当前温度比栈顶温度更高
                var pop = stack.pop()
                res[pop] = i - pop
            }
            stack.push(i)
        }
        return res
    }
}
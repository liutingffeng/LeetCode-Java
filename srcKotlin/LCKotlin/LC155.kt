package LCKotlin

import java.util.Stack
import kotlin.math.min

class LC155 {

    class MinStack() {
        var stack: Stack<Int> = Stack()
        var minStack: Stack<Int> = Stack()

        fun push(`val`: Int) {
            val cur = `val`
            stack.push(cur)
            if (minStack.empty() || cur <= getMin()) {
                minStack.push(cur)
            }
        }

        fun pop() {
            if (stack.empty()) {
                return
            }
            val topV = stack.pop()
            if (getMin() == topV) {
                minStack.pop()
            }
        }

        fun top(): Int {
           return stack.peek()
        }

        fun getMin(): Int {
            return minStack.peek()
        }
    }
}
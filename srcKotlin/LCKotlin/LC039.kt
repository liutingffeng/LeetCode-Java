package LCKotlin

import java.util.ArrayList

class LC039 {

    companion object {
        var result: MutableList<List<Int>> = ArrayList()
        var tar: Int = 0
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        result.clear()
        tar = target
        dfs(candidates, 0, 0, ArrayList())
        return result
    }

    fun dfs(candidates: IntArray, start: Int, curSum: Int, temps: MutableList<Int>) {
        if (start > candidates.lastIndex) {
            return
        }
        if (curSum > tar) return
        if (curSum == tar) {
            result.add(temps.toList())
            return
        }
        for (i in start..candidates.lastIndex) {
            var sum = curSum + candidates[i]
            temps.add(candidates[i])
            dfs(candidates, i, sum, temps)
            temps.removeLast()
        }
    }
}
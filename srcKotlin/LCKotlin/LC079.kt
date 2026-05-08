package LCKotlin

class LC079 {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (dfs(board, i, j, word, 0)) return true
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, word: String, idx: Int): Boolean {
        if (idx == word.length) return true
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size) return false
        if (board[i][j] != word[idx]) return false

        val tmp = board[i][j]
        board[i][j] = '#'
        val found = dfs(board, i + 1, j, word, idx + 1) ||
                dfs(board, i - 1, j, word, idx + 1) ||
                dfs(board, i, j + 1, word, idx + 1) ||
                dfs(board, i, j - 1, word, idx + 1)
        board[i][j] = tmp
        return found
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val board = arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            )
            println(LC079().exist(board, "ABCCED"))  // true
            println(LC079().exist(board, "SEE"))      // true
            println(LC079().exist(board, "ABCB"))     // false
        }
    }
}
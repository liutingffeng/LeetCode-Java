package LC2026;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC909 {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] boardList = new int[n * n + 1];

        // 按题目编号顺序把二维棋盘拉平成一维（1..n*n）
        int index = 1;
        boolean leftToRight = true;
        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    boardList[index++] = board[row][col];
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    boardList[index++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
        }

        return bfs(boardList, n);
    }

    private int bfs(int[] boardList, int n) {
        int target = n * n;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[target + 1];

        queue.offer(1);
        visited[1] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curObj = queue.poll();
                if (curObj == null) {
                    continue;
                }
                int cur = curObj;
                if (cur == target) {
                    return step;
                }

                for (int next = cur + 1; next <= Math.min(cur + 6, target); next++) {
                    // 这里 next 是骰子落点，只根据这个落点做一次映射到 dest，不会循环跳。
                    // 如果写成 while (boardList[dest] != -1) dest = boardList[dest];
                    // 才会变成“连续跳”，那就不符合题意。
                    int dest = boardList[next] == -1 ? next : boardList[next];
                    if (visited[dest]) {
                        continue;
                    }
                    if (dest == target) {
                        return step + 1;
                    }
                    visited[dest] = true;
                    queue.offer(dest);
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{-1, -1}, {-1, 3}};
        int res = new LC909().snakesAndLadders(board);
        System.out.println(res);
    }
}

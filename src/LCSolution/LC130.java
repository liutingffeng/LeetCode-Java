package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC130 {

    static class Solution {
        /*
X X X X
X O O X
X X O X
X O X X

-->
X X X X
X X X X
X X X X
X O X X
         */
//        public void solve(char[][] board) {
//            if (board == null || board.length == 0)
//                return;
//
//            //找到边界处，将其涂成‘Y'
//            int m = board.length;
//            int n = board[0].length;
//            for (int i=0;i<n;i++){
//                if (board[0][i] == 'O')
//                    foodfill(board,m,n, 0, i);
//                if (board[m-1][i] == 'O')
//                    foodfill(board,m,n, m-1, i);
//            }
//
//
//
//            for (int i=0;i<m;i++){
//                if (board[i][0] == 'O')
//                    foodfill(board,m,n, i, 0);
//                if (board[i][n-1] == 'O')
//                    foodfill(board,m,n, i, n-1);
//            }
//
//
//            //内部
//            for (int i=0;i<m;i++)
//                for (int j=0;j<n;j++){
//                    if (board[i][j] == 'O')
//                        board[i][j] = 'X';
//                    else if (board[i][j] == 'Y')
//                        board[i][j] = 'O';
//                }
//        }
//
//        private void foodfill(char[][] board,int m,int n,int x,int y){
//            if (x<0 || x>=m || y<0 || y>=n || board[x][y]!='O')
//                return;
//
//                board[x][y] = 'Y';
//                foodfill(board, m, n, x, y + 1);
//                foodfill(board, m, n, x, y - 1);
//                foodfill(board, m, n, x + 1, y);
//                foodfill(board, m, n, x - 1, y);
//
//        }

        int n, m;
        boolean[][] flag;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        public void solve(char[][] board) {
            if(board.length == 0 || board[0].length == 0) return;

            n = board.length;
            m = board[0].length;

            //flag = new boolean[n][m];
            for(int i = 0; i < n; i++){
                if(board[i][0] == 'O') dfs(board, i, 0);
                if(board[i][m-1] == 'O') dfs(board, i, m-1);
            }
            for(int i = 0; i < m; i++){
                if(board[0][i] == 'O') dfs(board, 0, i);
                if(board[n-1][i] == 'O') dfs(board, n-1, i);
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                    if(board[i][j] == 'Y'){
                        board[i][j] = 'O';
                    }
                }
            }
        }
        public void dfs(char[][] board, int i, int j){
            if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] !='O') return;
            board[i][j] = 'Y';
            // flag[i][j] = true;
            for(int k = 0; k < 4; k++){
                i = dx[k] + i;
                j = dy[k] + j;
                dfs(board, i, j);
                i = i-dx[k];
                j = j-dy[k];
            }

        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new Solution().solve(board);
    }
}

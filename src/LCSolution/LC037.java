package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC037 {

    class Solution {
//        public void solveSudoku(char[][] board) {
//            boolean[][] row = new boolean[9][10];
//            boolean[][] col = new boolean[9][10];
//            boolean[][] block = new boolean[9][10];
//
//            //初始化
//            for (int i=0;i<9;i++)
//                for (int j=0;j<9;j++){
//                    if (board[i][j]!='.'){
//                        row[i][board[i][j]-'0'] = true;
//                        col[j][board[i][j]-'0'] = true;
//                        block[i/3*3+j/3][board[i][j]-'0'] = true;
//                    }
//                }
//
//            for (int i=0;i<81;i++){
//                if(board[i / 9][i % 9] == '.'){
//                    dfs(board, i, row, col, block);
//                    return;
//                }
//            }
//        }
//
//        private boolean dfs(char[][] board,int count,boolean[][] row,boolean[][] col,boolean[][] block){
//
//            if (count>=81)
//                return true;
//
//            int nexpos = count+1;
//            for (;nexpos<81;nexpos++){
//                if (board[nexpos/9][nexpos%9] == '.')
//                    break;
//            }
//
//            int x = count/9, y = count%9;
//            for(char i = 1; i <= 9; i ++)
//                if(!row[x][i] && !col[y][i] && !block[x / 3 * 3 + y / 3][i]){
//                    row[x][i] = true;
//                    col[y][i] = true;
//                    block[x / 3 * 3 + y / 3][i] = true;
//                    board[x][y] = String.valueOf(i).toCharArray()[0];
//
//                    if(dfs(board, nexpos, row, col, block))
//                        return true;
//
//                    row[x][i] = false;
//                    col[y][i] = false;
//                    block[x / 3 * 3 + y / 3][i] = false;
//                    board[x][y] = '.';
//                }
//            return false;
//
//        }


        private boolean[][] row ;
        private boolean[][] col;
        int m;
        int n;
        public void solveSudoku(char[][] board) {
            m = 9;
            n = 9;
            row = new boolean[9][10];
            col = new boolean[9][10];
//初始化
            for (int i=0;i<9;i++)
                for (int j=0;j<9;j++){
                    if (board[i][j]!='.'){
                        row[i][board[i][j]-'0'] = true;
                        col[j][board[i][j]-'0'] = true;
                    }
                }
            recusion(board, 0, 0);
//            backtrack(board, 0, 0);
        }

        private boolean recusion(char[][] board,int x,int y){

            // 这一行算完了
            if (y == n){
                return recusion(board, x+1, 0);
            }

            // 结束
            if (x == m){
                return true;
            }

            if (board[x][y] != '.'){
                return recusion(board,x,y+1);
            }

            for (char c = '1';c<='9';c++){
                if (!isValid(board,x,y,c)){
                    continue;
                }
                //找到了一个该位置的解
                board[x][y] = c;
                row[x][c-'0'] = true;
                col[y][c-'0'] = true;
                if (recusion(board, x, y+1))
                    return true;
                row[x][c-'0'] = false;
                col[y][c-'0'] = false;
                board[x][y] = '.';
            }
            return false;
        }

        private boolean isValid(char[][] board, int x, int y,char c) {
            int num = c-'0';
            if (row[x][num])
                return false;

            if (col[y][num])
                return false;

            // 块
            for (int i = 0; i < 9; i++) {
                if (board[(x/3)*3+i/3][(y/3)*3+i%3] == c)
                    return false;
            }
            return true;
        }

//        boolean backtrack(char[][] board, int i, int j) {
//            int m = 9, n = 9;
//            if (j == n) {
//                // 穷举到最后一列的话就换到下一行重新开始。
//                return backtrack(board, i + 1, 0);
//            }
//            if (i == m) {
//                // 找到一个可行解，触发 base case
//                return true;
//            }
//
//            if (board[i][j] != '.') {
//                // 如果有预设数字，不用我们穷举
//                return backtrack(board, i, j + 1);
//            }
//
//            for (char ch = '1'; ch <= '9'; ch++) {
//                // 如果遇到不合法的数字，就跳过
//                if (!isValid(board, i, j, ch))
//                    continue;
//
//                board[i][j] = ch;
//                // 如果找到一个可行解，立即结束
//                if (backtrack(board, i, j + 1)) {
//                    return true;
//                }
//                board[i][j] = '.';
//            }
//            // 穷举完 1~9，依然没有找到可行解，此路不通
//            return false;
//        }

//        boolean isValid(char[][] board, int r, int c, char n) {
//            for (int i = 0; i < 9; i++) {
//                // 判断行是否存在重复
//                if (board[r][i] == n) return false;
//                // 判断列是否存在重复
//                if (board[i][c] == n) return false;
//                // 判断 3 x 3 方框是否存在重复
//                if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
//                    return false;
//            }
//            return true;
//        }
    }

    public static void main(String[] args) {
        System.out.println('1'-'0');
    }
}

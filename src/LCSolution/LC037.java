package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC037 {

    class Solution {
        public void solveSudoku(char[][] board) {
            boolean[][] row = new boolean[9][10];
            boolean[][] col = new boolean[9][10];
            boolean[][] block = new boolean[9][10];

            //初始化
            for (int i=0;i<9;i++)
                for (int j=0;j<9;j++){
                    if (board[i][j]!='.'){
                        row[i][board[i][j]-'0'] = true;
                        col[j][board[i][j]-'0'] = true;
                        block[i/3*3+j/3][board[i][j]-'0'] = true;
                    }
                }

            for (int i=0;i<81;i++){
                if(board[i / 9][i % 9] == '.'){
                    dfs(board, i, row, col, block);
                    return;
                }
            }
        }

        private boolean dfs(char[][] board,int count,boolean[][] row,boolean[][] col,boolean[][] block){

            if (count>=81)
                return true;

            int nexpos = count+1;
            for (;nexpos<81;nexpos++){
                if (board[nexpos/9][nexpos%9] == '.')
                    break;
            }

            int x = count/9, y = count%9;
            for(char i = 1; i <= 9; i ++)
                if(!row[x][i] && !col[y][i] && !block[x / 3 * 3 + y / 3][i]){
                    row[x][i] = true;
                    col[y][i] = true;
                    block[x / 3 * 3 + y / 3][i] = true;
                    board[x][y] = String.valueOf(i).toCharArray()[0];

                    if(dfs(board, nexpos, row, col, block))
                        return true;

                    row[x][i] = false;
                    col[y][i] = false;
                    block[x / 3 * 3 + y / 3][i] = false;
                    board[x][y] = '.';
                }
            return false;

        }
    }

    public static void main(String[] args) {
        System.out.println('0'+1 );
    }
}

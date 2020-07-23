package LCSolution;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC079 {

    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
  //          boolean[][] record = new boolean[m][n];
            for (int i=0;i<m;i++)
                for (int j=0;j<n;j++){
                    if (board[i][j] == word.charAt(0)){
                        boolean res = func(board, word, 1, i, j, m, n);
                        if (res)
                            return res;
                    }
                }
            return false;
        }

        private boolean func(char[][] board, String word,int index,int x,int y,int m,int n){
            if (index == word.length())
                return true;
            if (x<0 || x>=m || y<0 || y>=n){
                return false;
            }
            if (board[x][y] == word.charAt(index))
                return false;

            char temp = board[x][y];
            board[x][y] = '0';

            boolean res = func(board, word, index+1, x-1, y, m, n)
                    || func(board, word, index+1, x+1, y, m, n)
                    || func(board, word, index+1, x, y+1, m, n)
                    || func(board, word, index+1, x, y-1, m, n);
            board[x][y] = temp;
            return res;
        }
    }
}

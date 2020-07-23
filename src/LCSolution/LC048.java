package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC048 {

    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int mid = (n>>1)-1;
            //先沿着竖直方向中心线翻转
            for (int i=0;i<n;i++){
                for (int j=0;j<=mid;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-1-j];
                    matrix[i][n-j-1] = temp;
                }
            }
            System.out.println(matrix.toString());
            //再沿对角线翻转
            for (int i=0;i<n-1;i++){
                for (int j=0;j<n-i-1;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-j-1][n-i-1];
                    matrix[n-j-1][n-i-1] = temp;
                }
            }
        }

        public static void main(String[] args) {
            System.out.println(40000*40000);
        }
    }
}

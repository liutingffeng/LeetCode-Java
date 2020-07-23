package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC240 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return false;

            int m = matrix.length;
            int n = matrix[0].length;
            int x = 0,y=n-1;  //右上角
            while (true){
                if (x<0 || x>=m || y<0 || y>=n)
                    return false;
                if (matrix[x][y] == target)
                    return true;
                else if (matrix[x][y]<target){
                    x++;
                    continue;
                }
                else {
                    y--;
                }
            }
        }
    }
}

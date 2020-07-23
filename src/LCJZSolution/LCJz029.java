package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz029 {

    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0)
                return new int[0];
            int t = 0,b = matrix.length-1,l=0,r=matrix[0].length-1;
            int[] res = new int[(b+1)*(r+1)];
            int index = 0;

            while (true){
                //从左往右
                for (int i=l;i<=r;i++){
                    res[index++] = matrix[t][i];
                }
                if (++t>b)
                    break;

                //从上往下
                for (int i=t;i<=b;i++)
                    res[index++] = matrix[i][r];
                if (--r<l)
                    break;

                //从右往左
                for (int i=r;i>=l;i--)
                    res[index++] = matrix[b][i];
                if (--b < t)
                    break;

                //从下往上
                for (int i=b;i>=t;i--)
                    res[index++] = matrix[i][l];
                if (++l>r)
                    break;
            }
            return res;
        }
    }
}

package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC085 {

    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int res = 0;
            int[] dp = new int[n];
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    dp[j] = matrix[i][j] == '1'? dp[j]+1:0;
                }
                res = Math.max(res, largestRectangleArea(dp));
            }
            return res;
        }

        public int largestRectangleArea(int[] heights){
            if (heights == null || heights.length == 0)
                return 0;
            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            int[] new_heights = new int[heights.length+1];
            for (int i=0;i<heights.length;i++)
                new_heights[i] = heights[i];
            new_heights[heights.length] = 0;
            for (int i=0;i<new_heights.length;i++){
                while (!stack.isEmpty() && new_heights[i] < new_heights[stack.peek()] ){
                    int temp = stack.pop();
                    int left = stack.isEmpty()? -1:stack.peek();
                    res = Math.max(res, new_heights[temp]*(i-left-1));
                }
                stack.push(i);
            }
            return res;
        }
    }
}
